package com.dilon.filemanagerapp.general.info.administrative.repository;

import com.dilon.filemanagerapp.general.info.administrative.model.Administrative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AdministrativeRepository extends JpaRepository<Administrative, Integer>, JpaSpecificationExecutor<Administrative> {
    // Custom query methods can be defined here if needed
}
