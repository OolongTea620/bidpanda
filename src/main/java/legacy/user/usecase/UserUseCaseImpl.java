package legacy.user.usecase;

import legacy.user.entity.exception.NotFoundUserException;
import legacy.user.entity.gateway.UserUseCase;
import legacy.user.entity.model.User;
import legacy.user.infrastructure.dto.DeleteUserDto;
import legacy.user.infrastructure.dto.UpdateNickReqDto;
import legacy.user.infrastructure.gateway.UserDataBaseGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserUseCaseImpl implements UserUseCase {

  private final UserDataBaseGateway userDataBaseGateway;

  public User findByEmail(String email) {
    return userDataBaseGateway.findByEmail(email)
        .orElseThrow(NotFoundUserException::new);
  }

  @Override
  @Transactional
  public User updateNickname(UpdateNickReqDto updateNickReqDto) {
    User user = findByEmail(updateNickReqDto.getEmail());
    user.updateNickname(updateNickReqDto);
    user = userDataBaseGateway.save(user);
    return user;
  }

  @Override
  @Transactional
  public User delete(DeleteUserDto deleteUserDto) {
    User user = userDataBaseGateway.findById(deleteUserDto.getId())
        .orElseThrow(NotFoundUserException::new);
    user.cancel(deleteUserDto);
    user = userDataBaseGateway.save(user);
    return user;
  }


}
