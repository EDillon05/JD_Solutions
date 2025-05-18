package com.dilon.filemanagerapp.general.info.project.repository;

import com.dilon.filemanagerapp.general.info.project.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProjectRepository extends JpaRepository<Project, Integer>, JpaSpecificationExecutor<Project> {
    // Custom query methods can be defined here if needed
}
