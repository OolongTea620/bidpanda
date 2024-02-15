package legacy.user.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyInfoReqDto {

  public final String email;

  public MyInfoReqDto(String email) {
    this.email = email;
  }
}
