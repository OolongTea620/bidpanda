package com.panda.back.user.infrastructure.dto;

import com.panda.back.user.entity.model.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserCreateResVo {
    private final String email;
    private final String nickname;
    private final String createdAt;

    @Builder
    public UserCreateResVo(String email, String nickname, String createdAt) {
        this.email = email;
        this.nickname = nickname;
        this.createdAt = createdAt;
    }

    public static UserCreateResVo from(User user) {
        return UserCreateResVo.builder()
                .email(user.getEmail())
                .nickname(user.getNickname())
                .createdAt(user.getCreatedAt().toString())
                .build();
    }
}
