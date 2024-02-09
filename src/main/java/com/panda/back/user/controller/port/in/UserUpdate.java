package com.panda.back.user.controller.port.in;

import lombok.Builder;

public class UserUpdate {
    private final String nickname;

    @Builder
    public UserUpdate(String nickname) {
        this.nickname = nickname;
    }
}
