package com.panda.back.user.infrastucture.entity;

import com.panda.back.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Column(length = 255)
    private String description;

    private String createdAt;

    public static UserEntity from(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.email = user.getEmail();
        userEntity.password = user.getPassword();
        userEntity.nickname = user.getNickname();
        userEntity.description = "";
        return userEntity;
    }

    public User toModel() {
        return User.builder()
                .id(id)
                .email(email)
                .password(password)
                .nickname(nickname)
                .build();
    }
}
