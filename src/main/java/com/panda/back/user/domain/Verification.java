package com.panda.back.user.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Verification {

  private final String email;
  private final Integer verificationCode;
  private final boolean status;

  @Builder
  public Verification(String email, Integer verificationCode, boolean status) {
    this.email = email;
    this.verificationCode = verificationCode;
    this.status = status;
  }

  // 랜덤 코드를 만들고 반환 한다.
  public Verification generateCode() {
    return null;
  }

  // 반환을 한다.
  public Verification verifyEmail() {
    return null;
  }

}
