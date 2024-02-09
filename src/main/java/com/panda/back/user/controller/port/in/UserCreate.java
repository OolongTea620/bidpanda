package com.panda.back.user.controller.port.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserCreate {
    private final String email;
    private final String password;
    private final String nickname;

    @Builder
    public UserCreate(
            @JsonProperty("email") String email,
            @JsonProperty("password") String password,
            @JsonProperty("nickname") String nickname
    ) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }
}
