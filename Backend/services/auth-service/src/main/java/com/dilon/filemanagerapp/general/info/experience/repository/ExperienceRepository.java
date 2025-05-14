package com.dilon.filemanagerapp.general.info.experience.repository;

import com.dilon.filemanagerapp.general.info.experience.model.Experience;
import com.dilon.filemanagerapp.profile.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
    List<Experience> findAllByOwner(Profile profile);
    // Custom query methods can be defined here if needed
}
