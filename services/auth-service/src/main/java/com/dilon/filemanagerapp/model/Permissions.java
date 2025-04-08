package com.dilon.filemanagerapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Permissions {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    @ManyToMany (mappedBy = "permissions")
    private Set<Roles> roles = new HashSet<>();
}
