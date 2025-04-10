package com.dilon.filemanagerapp.service;

import com.dilon.filemanagerapp.dto.RegisterRequest;
import com.dilon.filemanagerapp.dto.UserResponse;
import com.dilon.filemanagerapp.model.Roles;
import com.dilon.filemanagerapp.repository.RoleRepository;
import com.dilon.filemanagerapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final RoleRepository roleRepository;

    private final UserRepository repository;

    private final UserMapper mapper;

    public Integer registerUser(RegisterRequest request) {
        var user = mapper.toUser(request);

        // 👇 Cargar los roles por ID para que no estén detached
        Set<Roles> managedRoles = request.roles().stream()
                .map(role -> roleRepository.findById(role.getId())
                        .orElseThrow(() -> new RuntimeException("Role not found: " + role.getId())))
                .collect(Collectors.toSet());

        user.setRoles(managedRoles);

        var saved = repository.save(user);
        return saved.getId();
    }

    public List<UserResponse> findAllCustomers() {
        return repository.findAll()
                .stream()
                .map(this.mapper::fromUser)
                .collect(Collectors.toList());
    }
}

