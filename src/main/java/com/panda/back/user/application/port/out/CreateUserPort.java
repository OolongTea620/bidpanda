package com.panda.back.user.application.port.out;

import com.panda.back.user.domain.User;

public interface CreateUserPort {

  User save(User user);
}
