package legacy.user.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateNickReqDto {

  private String email;
  @JsonProperty(required = true)
  private String nickname;

  @Builder
  public UpdateNickReqDto(String email, String nickname) {
    this.email = email;
    this.nickname = nickname;
  }
}
