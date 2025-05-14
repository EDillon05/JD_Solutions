package com.dilon.filemanagerapp.common.service;

import com.dilon.filemanagerapp.auth.model.User;
import com.dilon.filemanagerapp.common.model.BaseDocumentEntity;
import com.dilon.filemanagerapp.profile.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;

public abstract class BaseDocumentService<E extends BaseDocumentEntity, D> {

    protected abstract JpaRepository<E, Integer> getRepository();
    protected abstract E mapToEntity(D dto);

    public Integer save(D dto, Authentication connectedUser) {
        User user = (User) connectedUser.getPrincipal();
        Profile profile = user.getProfile();
        if (profile == null) {
            throw new IllegalStateException("El usuario no tiene un perfil asociado.");
        }

        E entity = mapToEntity(dto);
        entity.setOwner(profile); // establece la relación
        return getRepository().save(entity).getId(); // guarda y retorna el ID
    }
}

