package com.panda.back.user.adapter.in.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SendVerificationCodeReq {

  private final String email;

  @Builder
  public SendVerificationCodeReq(String email) {
    this.email = email;
  }

}
