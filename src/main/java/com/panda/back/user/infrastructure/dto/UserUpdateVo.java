package com.panda.back.user.infrastructure.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserUpdateVo {
    private final String email;
    private final String password;
    private final String nickname;

    @Builder
    public UserUpdateVo(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }
}