package com.dilon.filemanagerapp.repository;

import com.dilon.filemanagerapp.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Roles, Integer> {

    Optional<Roles> findByName(String roleName);

}
