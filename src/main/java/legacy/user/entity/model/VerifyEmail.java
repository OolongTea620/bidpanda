package legacy.user.entity.model;

import com.panda.back.global.usercase.port.RandomCodeHolder;
import lombok.Builder;
import lombok.Getter;

@Getter
public class VerifyEmail {

  private final String email;
  private final String verificationCode;

  @Builder
  public VerifyEmail(String email, String verificationCode) {
    this.email = email;
    this.verificationCode = verificationCode;
  }

  public VerifyEmail generateVerifyCode(String email, RandomCodeHolder randomCodeHolder) {
    return VerifyEmail.builder()
        .email(email)
        .verificationCode(randomCodeHolder.generateRandomCode())
        .build();
  }
}