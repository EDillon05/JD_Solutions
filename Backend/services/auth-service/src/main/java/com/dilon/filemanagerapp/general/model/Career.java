package com.dilon.filemanagerapp.general.model;

import com.dilon.filemanagerapp.common.BaseDocumentEntity;
import com.dilon.filemanagerapp.profile.model.Profile;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity
@Table(name = "career")
@PrimaryKeyJoinColumn(name = "id")
public class Career extends BaseDocumentEntity {
    private String level;
    private String institution;
    private String certification_name;
    private String licenseId;
    private String modality;
    private LocalDateTime graduation_date;
    private String status;

}
