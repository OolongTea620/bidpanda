package com.panda.back.user.infrastructure.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserCreateVo {
    private final String email;
    private final String password;
    private final String nickname;

    @Builder
    public UserCreateVo(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    public static UserCreateVo from(UserCreateReqDto userCreateReqDto) {
        return UserCreateVo.builder()
                .email(userCreateReqDto.getEmail())
                .password(userCreateReqDto.getPassword())
                .nickname(userCreateReqDto.getNickname())
                .build();
    }
}