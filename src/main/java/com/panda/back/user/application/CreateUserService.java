package com.panda.back.user.application;

import com.panda.back.user.application.port.in.CreateUserUseCase;
import com.panda.back.user.application.port.in.dto.CreateUserDto;
import com.panda.back.user.application.port.out.CreateUserPort;
import com.panda.back.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {

  private final CreateUserPort createUserPort;

  @Override
  @Transactional
  public User create(CreateUserDto createUserDto) {
    //TODO : 비번 암호화 작업
    User user = User.from(createUserDto);
    user = createUserPort.save(user);
    return user;
  }
}
