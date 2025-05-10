package com.dilon.filemanagerapp.profile.model;

import com.dilon.filemanagerapp.auth.model.User;
import com.dilon.filemanagerapp.common.BaseDocumentEntity;
import com.dilon.filemanagerapp.general.model.Experience;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "profile")
public class Profile extends User {
    private String profilePictureUrl;

    private String bio;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Experience> experiences;

}
