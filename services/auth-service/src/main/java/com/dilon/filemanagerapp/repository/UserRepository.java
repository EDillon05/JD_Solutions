package com.dilon.filemanagerapp.repository;

import com.dilon.filemanagerapp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
}
