package com.panda.back.user.adapter.in.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SendVerificationCodeRes {

  private final boolean sendSuccess;

  @Builder
  public SendVerificationCodeRes(boolean sendSuccess) {
    this.sendSuccess = sendSuccess;
  }
}
