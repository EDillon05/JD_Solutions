package com.dilon.filemanagerapp.general.info.administrative.model;

import com.dilon.filemanagerapp.common.model.BaseDocumentEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity
@Table(name = "administrative")
@PrimaryKeyJoinColumn(name = "id")
public class Administrative extends BaseDocumentEntity {
    private String position; //e.g. Head of Department, etc.
    private String academicUnit; //e.g. Department of Computer Science, etc.
    private String institution; //e.g. University of XYZ, etc.
    private String level; //e.g. National, International, etc.
    private String modality; //e.g. Full-time, Part-time, etc.
}
