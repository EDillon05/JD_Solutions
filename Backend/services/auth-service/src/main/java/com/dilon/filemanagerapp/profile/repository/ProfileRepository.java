package com.dilon.filemanagerapp.profile.repository;

import com.dilon.filemanagerapp.profile.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProfileRepository extends JpaRepository<Profile, Integer>, JpaSpecificationExecutor<Profile> {
    // Custom query methods can be defined here if needed
}
