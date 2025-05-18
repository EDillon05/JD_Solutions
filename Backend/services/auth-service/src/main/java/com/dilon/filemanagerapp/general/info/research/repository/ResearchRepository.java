package com.dilon.filemanagerapp.general.info.research.repository;

import com.dilon.filemanagerapp.general.info.research.model.Research;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ResearchRepository extends JpaRepository<Research, Integer>, JpaSpecificationExecutor<Research> {
    // Custom query methods can be defined here if needed
}
