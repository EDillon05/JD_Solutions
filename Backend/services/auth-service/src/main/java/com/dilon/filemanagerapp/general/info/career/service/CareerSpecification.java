package com.dilon.filemanagerapp.general.info.career.service;

import com.dilon.filemanagerapp.general.info.career.model.Career;
import org.springframework.data.jpa.domain.Specification;

public class CareerSpecification {

    public static Specification<Career> withOwnerId(Integer ownerId) {
        return (root, query, criteriaBuilder) -> {
            if (ownerId == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("owner").get("id"), ownerId);
        };
    }
}
