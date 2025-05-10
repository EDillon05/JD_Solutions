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
@Table(name = "experience")
@PrimaryKeyJoinColumn(name = "id")
public class Experience extends BaseDocumentEntity {
    private String companyName;
    private String position;
    private String area;
    private String contractType;

}
