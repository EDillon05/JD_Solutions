package com.dilon.filemanagerapp.general.info.project.model;

import com.dilon.filemanagerapp.common.model.BaseDocumentEntity;
import com.dilon.filemanagerapp.general.info.research.model.Research;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity
@Table(name = "project")
@PrimaryKeyJoinColumn(name = "id")
public class Project extends BaseDocumentEntity {
    private String role;
    private String institutionName;//e.g. university, company, etc.
    private String budget;
    private String projectLink; //e.g. GitHub link
    private LocalDateTime publicationDate;
    private String disciplinaryArea;

    @ManyToMany
    @JoinTable(
            name = "project_research",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "research_id")
    )
    private Set<Research> researchProjects;
}
