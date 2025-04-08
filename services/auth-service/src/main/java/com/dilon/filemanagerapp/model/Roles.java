package com.dilon.filemanagerapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Roles {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    @ManyToMany
    @JoinTable(
    name = "roles_permisos",
    joinColumns = @JoinColumn(name = "rol_id"),
    inverseJoinColumns = @JoinColumn(name = "permiso_id")
    )
    private Set<Permissions> permissions = new HashSet<>();

}
