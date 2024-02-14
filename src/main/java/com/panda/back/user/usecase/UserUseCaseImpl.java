package com.panda.back.user.usecase;

import com.panda.back.user.entity.exception.NotFoundUserException;
import com.panda.back.user.entity.gateway.UserUseCase;
import com.panda.back.user.entity.model.User;
import com.panda.back.user.infrastructure.dto.DeleteUserDto;
import com.panda.back.user.infrastructure.dto.UpdateNickReqDto;
import com.panda.back.user.infrastructure.gateway.UserDataBaseGateway;
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
