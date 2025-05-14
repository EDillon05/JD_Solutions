package com.dilon.filemanagerapp.common.service;

import com.dilon.filemanagerapp.common.model.BaseDocumentEntity;
import com.dilon.filemanagerapp.profile.model.Profile;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class BaseSpecificationBuilder<T extends BaseDocumentEntity> {
    public Specification<T> buildSpec(String keyword, String type, LocalDateTime startedAt, LocalDateTime finishedAt, Profile owner){
        return Specification
                .where(ownerEqual(owner))
                .and(keywordLike(keyword))
                .and(typeEqual(type))
                .and(startedAtBetween(startedAt, finishedAt));
    }

    private Specification<T> ownerEqual(Profile owner) {
        return (root, query, criteriaBuilder) -> {
            if (owner == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("owner"), owner);
        };
    }

    private Specification<T> keywordLike(String keyword) {
        return (root, query, criteriaBuilder) -> {
            if (keyword == null || keyword.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("name"), "%" + keyword + "%");
        };
    }

    private Specification<T> typeEqual(String type) {
        return (root, query, criteriaBuilder) -> {
            if (type == null || type.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("type"), type);
        };
    }

    private Specification<T> startedAtBetween(LocalDateTime startedAt, LocalDateTime finishedAt) {
        if (startedAt == null && finishedAt == null) return null;
        if (startedAt != null && finishedAt != null)
            return (root, query, cb) -> cb.between(root.get("startedAt"), startedAt, finishedAt);
        if (startedAt != null)
            return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("startedAt"), startedAt);
        return (root, query, cb) -> cb.lessThanOrEqualTo(root.get("startedAt"), finishedAt);
    }
}
