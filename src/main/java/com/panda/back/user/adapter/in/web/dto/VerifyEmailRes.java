package com.panda.back.user.adapter.in.web.dto;

import lombok.Getter;

@Getter
public class VerifyEmailRes {

  private final boolean isVerified;

  public VerifyEmailRes(boolean isVerified) {
    this.isVerified = isVerified;
  }

}
