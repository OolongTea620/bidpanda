package legacy.user.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IsAvailableEmailDto {

  private boolean isAvailable;

  public IsAvailableEmailDto(boolean isAvailable) {
    this.isAvailable = isAvailable;
  }
}
