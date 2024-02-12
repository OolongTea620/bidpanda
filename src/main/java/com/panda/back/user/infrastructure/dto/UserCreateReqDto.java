package com.panda.back.user.infrastructure.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserCreateReqDto {
    private final String email;
    private final String password;
    private final String nickname;

    @Builder
    public UserCreateReqDto(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }
}