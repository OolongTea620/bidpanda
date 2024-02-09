package com.panda.back.user.domain;

import com.panda.back.user.controller.port.in.UserCreate;
import lombok.Builder;
import lombok.Getter;

@Getter
public class User {
    private final Long id;
    private final String email;
    private final String password;
    private final String nickname;

    @Builder
    public User(Long id, String email, String password, String nickname) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    public static User from(UserCreate userCreate) {
        return User.builder()
                .email(userCreate.getEmail())
                .password(userCreate.getPassword())
                .nickname(userCreate.getNickname())
                .build();
    }
}
