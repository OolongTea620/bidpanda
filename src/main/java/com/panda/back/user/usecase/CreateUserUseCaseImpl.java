package com.panda.back.user.usecase;

import com.panda.back.user.entity.gateway.CreateUserUseCase;
import com.panda.back.user.entity.model.User;
import com.panda.back.user.infrastructure.dto.CreateUserUseCaseDto;
import com.panda.back.user.infrastructure.gateway.UserDataBaseGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {

  private final UserDataBaseGateway userDataBaseGateway;

  @Override
  @Transactional
  public User create(CreateUserUseCaseDto createUserUseCaseDto) {
    return userDataBaseGateway.save(User.from(createUserUseCaseDto));
  }
}
