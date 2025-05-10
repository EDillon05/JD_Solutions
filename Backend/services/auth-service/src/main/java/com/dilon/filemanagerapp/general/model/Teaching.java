package com.dilon.filemanagerapp.general.model;

import com.dilon.filemanagerapp.common.BaseDocumentEntity;
import com.dilon.filemanagerapp.profile.model.Profile;
import jakarta.persistence.*;
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
@Table(name = "teaching")
@PrimaryKeyJoinColumn(name = "id")
public class Teaching extends BaseDocumentEntity {
    private String assessmentName;
    private String programName;
    private String level;
    private String institution;
    private String modality;
    private String weeklyHours;

}
