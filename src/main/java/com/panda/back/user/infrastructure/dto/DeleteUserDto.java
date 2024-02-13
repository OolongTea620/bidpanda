package com.panda.back.user.infrastructure.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteUserDto {

  private final Long id;
  private final String email;

  @Builder
  public DeleteUserDto(Long id, String email) {
    this.id = id;
    this.email = email;
  }
}
