package com.dilon.filemanagerapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String Name;
    private String LastName1;
    private String LastName2;
    private String Email;
    private String Password;
    private String Phone;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @ManyToMany
     @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private Set<Roles> roles = new HashSet<>();

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();  // Asigna la fecha y hora actual al campo createdAt
    }
}
