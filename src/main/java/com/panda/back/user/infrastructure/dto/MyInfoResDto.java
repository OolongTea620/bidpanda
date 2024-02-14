package com.panda.back.user.infrastructure.dto;

import lombok.Getter;

@Getter
public class MyInfoResDto {

  private final String email;
  private final String nickname;
  private final String createdAt;

  public MyInfoResDto(String email, String nickname, String createdAt) {
    this.email = email;
    this.nickname = nickname;
    this.createdAt = createdAt;
  }
}
