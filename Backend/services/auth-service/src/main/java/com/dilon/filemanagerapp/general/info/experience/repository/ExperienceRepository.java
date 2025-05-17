package com.dilon.filemanagerapp.general.info.experience.repository;

import com.dilon.filemanagerapp.general.info.experience.model.Experience;
import com.dilon.filemanagerapp.profile.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience, Integer>, JpaSpecificationExecutor<Experience> {
    // Custom query methods can be defined here if needed
}
