package com.panda.back.user.application.port.out;

import com.panda.back.user.domain.Verification;

public interface VerifyUserPort {

  void saveVerification(Verification verification);

  void findByEmail(Verification verification);


}
