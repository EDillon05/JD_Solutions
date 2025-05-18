package com.dilon.filemanagerapp.general.info.recognition.model;

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
@Table(name = "recognition")
@PrimaryKeyJoinColumn(name = "id")
public class Recognition extends BaseDocumentEntity {
    private String institutionGiven;
    private String reason;
    private String level;
    private String typeOfRecognition; //e.g. award, certificate, etc.
}
