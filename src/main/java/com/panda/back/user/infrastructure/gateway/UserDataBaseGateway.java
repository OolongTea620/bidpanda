package com.panda.back.user.infrastructure.gateway;

import com.panda.back.user.entity.model.User;
import com.panda.back.user.entity.model.UserStatus;
import java.util.Optional;

public interface UserDataBaseGateway {

  User save(User user);

  Optional<User> findByIdAndStatus(Long id, UserStatus userStatus);

  Optional<User> findByEmail(String email);
}
