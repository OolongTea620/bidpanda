package com.panda.back.user.application.port.out;

import com.panda.back.user.domain.User;
import java.util.Optional;

public interface ReadUserPort {

  Optional<User> findById(Long id);

  Optional<User> findByEmail(String email);

}
