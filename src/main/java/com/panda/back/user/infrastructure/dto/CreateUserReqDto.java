package com.panda.back.user.infrastructure.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserReqDto {

  private final String email;
  private final String password;
  private final String nickname;

  @Builder
  public CreateUserReqDto(String email, String password, String nickname) {
    this.email = email;
    this.password = password;
    this.nickname = nickname;
  }
}