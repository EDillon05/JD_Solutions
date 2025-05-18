package com.dilon.filemanagerapp.common.service;

import com.dilon.filemanagerapp.auth.model.User;
import com.dilon.filemanagerapp.common.dto.PageResponse;
import com.dilon.filemanagerapp.common.model.BaseDocumentEntity;
import com.dilon.filemanagerapp.common.repository.UpdateRequest;
import com.dilon.filemanagerapp.profile.model.Profile;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.security.core.Authentication;

import java.time.LocalDateTime;
import java.util.List;

import static com.dilon.filemanagerapp.common.service.BaseSpecificationBuilder.withOwnerId;

@RequiredArgsConstructor
public abstract class BaseDocumentService<Entity extends BaseDocumentEntity, Req extends UpdateRequest, Res> {

    protected abstract JpaRepository<Entity, Integer> getRepository();

    protected abstract JpaSpecificationExecutor<Entity> getSpecificationExecutor();

    protected abstract Entity mapToEntity(Req req);

    protected abstract Res mapToResponse(Entity entity);


    public Integer save(Req dtoReq, Authentication connectedUser) {
        User user = (User) connectedUser.getPrincipal();
        Profile profile = user.getProfile();
        if (profile == null) {
            throw new IllegalStateException("El usuario no tiene un perfil asociado.");
        }

        Entity entity = mapToEntity(dtoReq);
        entity.setOwner(profile); // establece la relación
        return getRepository().save(entity).getId(); // guarda y retorna el ID
    }

    public Res findById(Integer documentId, Authentication connectedUser) {
        User user = (User) connectedUser.getPrincipal();
        Profile profile = user.getProfile();

        return getRepository().findById(documentId)
                .filter(doc -> doc.getOwner().getId().equals(profile.getId()))
                .map(this::mapToResponse)
                .orElseThrow(() -> new EntityNotFoundException("Document not found or access denied with id: " + documentId));
    }

    public PageResponse<Res> findAllByOwner(int page, int size, Authentication auth) {
        User user = (User) auth.getPrincipal();
        Profile profile = user.getProfile();

        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());

        Page<Entity> documents = getSpecificationExecutor().findAll(withOwnerId(profile.getId()), pageable);

        List<Res> responses = documents.stream()
                .map(this::mapToResponse)
                .toList();

        return new PageResponse<>(responses,
                documents.getNumber(),
                documents.getSize(),
                documents.getTotalElements(),
                documents.getTotalPages(),
                documents.isFirst(),
                documents.isLast());
    }

    public PageResponse<Res> searchByFilters(int page, int size, String keyword, String type, LocalDateTime startedAt, LocalDateTime finishedAt, Authentication auth) {
        User user = (User) auth.getPrincipal();
        Profile profile = user.getProfile();

        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").ascending());

        BaseSpecificationBuilder<Entity> builder = new BaseSpecificationBuilder<>();
        Specification<Entity> spec = builder.buildSpec(keyword, type, startedAt, finishedAt, profile);

        Page<Entity> documents = getSpecificationExecutor().findAll(spec, pageable);

        List<Res> entityResponses = documents
                .stream()
                .filter(doc -> doc.getOwner().getId().equals(profile.getId()))
                .map(this::mapToResponse)
                .toList();

        return new PageResponse<>(
                entityResponses,
                documents.getNumber(),
                documents.getSize(),
                documents.getTotalElements(),
                documents.getTotalPages(),
                documents.isFirst(),
                documents.isLast()
        );
    }

    public void deleteById (Integer documentId, Authentication connectedUser) {
        User user = (User) connectedUser.getPrincipal();
        Profile profile = user.getProfile();

        Entity entity = getRepository().findById(documentId)
                .filter(doc -> doc.getOwner().getId().equals(profile.getId()))
                .orElseThrow(() -> new EntityNotFoundException("Document not found or access denied with id: " + documentId));

        getRepository().delete(entity);
    }

public void update(@Valid Req request, Authentication auth) {
    User user = (User) auth.getPrincipal();
    Profile profile = user.getProfile();

    Entity entity = getRepository().findById(request.getId())
            .filter(doc -> doc.getOwner().getId().equals(profile.getId()))
            .orElseThrow(() -> new EntityNotFoundException("Document not found or access denied with id: " + request.getId()));

    Entity updatedEntity = mapToEntity(request);
    updatedEntity.setId(entity.getId());
    updatedEntity.setOwner(entity.getOwner());

    getRepository().save(updatedEntity);
}
}


