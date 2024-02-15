package com.panda.back.user.application.port;

import com.panda.back.user.application.port.in.CreateUserUseCase;
import com.panda.back.user.application.port.in.dto.CreateUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {


  @Override
  public void sendVerificationCode(String email) {
    
  }

  @Override
  public void verifyEmail(String email) {

  }

  @Override
  public CreateUserDto create(CreateUserDto createUserDto) {
    return null;
  }
}
