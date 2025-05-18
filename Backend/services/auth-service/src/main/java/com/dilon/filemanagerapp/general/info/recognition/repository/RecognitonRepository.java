package com.dilon.filemanagerapp.general.info.recognition.repository;

import com.dilon.filemanagerapp.general.info.recognition.model.Recognition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RecognitonRepository extends JpaRepository<Recognition, Integer>, JpaSpecificationExecutor<Recognition> {
    // Custom query methods can be defined here if needed
}
