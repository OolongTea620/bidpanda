package legacy.user.entity.model;

import legacy.user.entity.exception.UnAuthorizedUserException;
import legacy.user.infrastructure.dto.CreateUserUseCaseDto;
import legacy.user.infrastructure.dto.DeleteUserDto;
import legacy.user.infrastructure.dto.UpdateNickReqDto;
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

  public static User from(CreateUserUseCaseDto createUserUseCaseDto) {
    return User.builder()
        .email(createUserUseCaseDto.getEmail())
        .password(createUserUseCaseDto.getPassword())
        .nickname(createUserUseCaseDto.getNickname())
        .status(UserStatus.ACTIVE)
        .build();
  }

  public User updateNickname(UpdateNickReqDto updateNickReqDto) {
    if (status.equals(UserStatus.INACTIVE)) {
      throw new UnAuthorizedUserException();
    }
    return User.builder()
        .id(id)
        .email(email)
        .password(password)
        .nickname(updateNickReqDto.getNickname())
        .createdAt(createdAt)
        .status(status)
        .build();
  }

  public User cancel(DeleteUserDto deleteUserDto) {
    if (!email.equals(deleteUserDto.getEmail())) {
      throw new UnAuthorizedUserException();
    }
    return User.builder()
        .id(id)
        .email(email)
        .password(password)
        .nickname(nickname)
        .createdAt(createdAt)
        .status(UserStatus.INACTIVE)
        .build();
  }

}
