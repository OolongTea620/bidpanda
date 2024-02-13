package com.panda.back.user.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateNickReqDto {

  @JsonProperty(required = true)
  private String nickname;

  @Builder
  public UpdateNickReqDto(String nickname) {
    this.nickname = nickname;
  }
}
