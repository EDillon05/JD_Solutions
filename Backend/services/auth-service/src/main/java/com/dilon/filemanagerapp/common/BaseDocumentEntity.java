package com.dilon.filemanagerapp.common;


import com.dilon.filemanagerapp.profile.model.Profile;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@EntityListeners(AuditingEntityListener.class)
public class BaseDocumentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;
    private String description;
    private String country;
    private LocalDateTime startedAt;
    private LocalDateTime finishedAt;
    private String comment;
    private String url;
    private String status;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false, unique = true)
    private Profile owner;

//    @ManyToOne
//    @JoinColumn(name = "owner_id")
//    private Profile owner;
//
//    @OneToOne(mappedBy = "document")
//    private Experience experiences;
//    @OneToOne(mappedBy = "document")
//    private Career careers;
//    @OneToOne(mappedBy = "document")
//    private Teaching teachings;
}
