package com.panda.back.user.infrastructure.dto;

import com.panda.back.user.entity.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserResDto {

  private final String email;
  private final String nickname;
  private final String createdAt;

  @Builder
  public CreateUserResDto(String email, String nickname, String createdAt) {
    this.email = email;
    this.nickname = nickname;
    this.createdAt = createdAt;
  }

  public static CreateUserResDto from(User user) {
    return CreateUserResDto.builder()
        .email(user.getEmail())
        .nickname(user.getNickname())
        .createdAt(user.getCreatedAt().toString())
        .build();
  }
}
