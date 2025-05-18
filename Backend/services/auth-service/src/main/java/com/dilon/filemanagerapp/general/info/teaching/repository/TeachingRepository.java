package com.dilon.filemanagerapp.general.info.teaching.repository;

import com.dilon.filemanagerapp.general.info.teaching.model.Teaching;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeachingRepository extends JpaRepository<Teaching, Integer>, JpaSpecificationExecutor<Teaching> {
    // Custom query methods can be defined here if needed
}
