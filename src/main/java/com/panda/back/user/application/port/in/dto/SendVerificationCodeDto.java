package com.panda.back.user.application.port.in.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SendVerificationCodeDto {

  private final String email;
  private final boolean sendSuccess;

  @Builder
  public SendVerificationCodeDto(String email, boolean sendSuccess) {
    this.email = email;
    this.sendSuccess = sendSuccess;
  }
}
