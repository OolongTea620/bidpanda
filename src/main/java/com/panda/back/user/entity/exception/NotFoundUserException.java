package com.panda.back.user.entity.exception;

public class NotFoundUserException extends RuntimeException {

  public NotFoundUserException() {
    super("유효하지 않는 유저입니다");
  }
}
