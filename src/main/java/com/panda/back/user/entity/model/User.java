package com.panda.back.user.entity.model;

import com.panda.back.user.infrastructure.dto.UserCreateVo;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class User {

  private final Long id;
  private final String email;
  private final String password;
  private final String nickname;
  private final LocalDateTime createdAt;
  private final UserStatus status;

  @Builder
  public User(Long id, String email, String password, String nickname, LocalDateTime createdAt,
      UserStatus status) {
    this.id = id;
    this.email = email;
    this.password = password;
    this.nickname = nickname;
    this.createdAt = createdAt;
    this.status = status;
  }

  public static User from(UserCreateVo userCreateVo) {
    return User.builder()
        .email(userCreateVo.getEmail())
        .password(userCreateVo.getPassword())
        .nickname(userCreateVo.getNickname())
        .status(UserStatus.ACTIVE)
        .build();
  }
}
