package com.panda.back.user.application.port.in.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDto {

  private String email;
  private String password;
  private String nickname;

  @Builder
  public CreateUserDto(String email, String password, String nickname) {
    this.email = email;
    this.password = password;
    this.nickname = nickname;
  }

}
