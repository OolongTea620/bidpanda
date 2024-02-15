package com.panda.back.user.adapter.in.web.dto;

import lombok.Getter;

@Getter
public class VerifyEmailRes {

  private final boolean sendEmail;

  public VerifyEmailRes(boolean sendEmail) {
    this.sendEmail = sendEmail;
  }
}
