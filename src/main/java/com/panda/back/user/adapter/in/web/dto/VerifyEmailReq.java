package com.panda.back.user.adapter.in.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class VerifyEmailReq {

  public final String email;
  private final String verificationCode;

  @Builder
  public VerifyEmailReq(String email, String verificationCode) {
    this.email = email;
    this.verificationCode = verificationCode;
  }
}
