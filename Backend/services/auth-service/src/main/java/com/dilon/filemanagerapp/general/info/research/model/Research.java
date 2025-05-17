package com.dilon.filemanagerapp.general.info.research.model;

import com.dilon.filemanagerapp.common.model.BaseDocumentEntity;
import com.dilon.filemanagerapp.general.info.project.model.Project;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
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
@Table(name = "research")
@PrimaryKeyJoinColumn(name = "id")
public class Research extends BaseDocumentEntity {
    private String publicationType; //e.g. book, article, etc.
    private String publicationTitle;
    private String magazineName; //if applicable
    private LocalDateTime publicationDate; //if applicable
    private String doi; //Digital Object Identifier
    private String isbn;
    private String eventName; //if applicable

    @ManyToMany(mappedBy = "researchProjects")
    private Set<Project> projects;
}
