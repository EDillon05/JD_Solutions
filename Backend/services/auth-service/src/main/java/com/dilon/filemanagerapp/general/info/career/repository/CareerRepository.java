package com.dilon.filemanagerapp.general.info.career.repository;

import com.dilon.filemanagerapp.general.info.career.model.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CareerRepository extends JpaRepository<Career, Integer>, JpaSpecificationExecutor<Career> {
    // Custom query methods can be defined here if needed
}
