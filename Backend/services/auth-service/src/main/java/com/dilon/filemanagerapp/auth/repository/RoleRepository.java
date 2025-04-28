package com.dilon.filemanagerapp.auth.repository;

import com.dilon.filemanagerapp.auth.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Roles, Integer> {

    Optional<Roles> findByName(String roleName);

}
