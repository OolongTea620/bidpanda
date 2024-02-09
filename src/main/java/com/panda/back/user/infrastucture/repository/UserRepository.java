package com.panda.back.user.infrastucture.repository;

import com.panda.back.user.domain.User;
import com.panda.back.user.domain.UserStatus;

import java.util.Optional;

public interface UserRepository {
    User getById(Long id);
    Optional<User> findByIdAndStatus(Long id, UserStatus userStatus);
    Optional<User> findByEmail(String email);
    User save(User user);
}
