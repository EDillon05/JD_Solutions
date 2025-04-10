package com.dilon.filemanagerapp.repository;

import com.dilon.filemanagerapp.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Integer> {

}
