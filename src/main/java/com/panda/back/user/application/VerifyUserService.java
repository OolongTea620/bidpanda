package com.panda.back.user.application;

import com.panda.back.user.application.port.in.VerifyUserUseCase;
import com.panda.back.user.application.port.in.dto.SendVerificationCodeDto;
import com.panda.back.user.application.port.in.dto.VerifyEmailDto;
import org.springframework.stereotype.Service;

@Service
public class VerifyUserService implements VerifyUserUseCase {

  @Override
  public SendVerificationCodeDto sendEmail(SendVerificationCodeDto sendVerificationCodeDto) {
    return null;
  }

  @Override
  public VerifyEmailDto verify(VerifyEmailDto verifyEmailDto) {
    return null;
  }
}
