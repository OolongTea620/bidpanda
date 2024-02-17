package com.panda.back.user.adapter.out.persistance;

import com.panda.back.user.adapter.out.persistance.jpa.entity.UserEntity;
import com.panda.back.user.adapter.out.persistance.jpa.resposiory.UserRepository;
import com.panda.back.user.application.port.out.CreateUserPort;
import com.panda.back.user.application.port.out.DeleteUserPort;
import com.panda.back.user.application.port.out.ReadUserPort;
import com.panda.back.user.application.port.out.UpdateUserPort;
import com.panda.back.user.domain.User;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements CreateUserPort, ReadUserPort, UpdateUserPort,
    DeleteUserPort {

  private final UserRepository userRepository;

  @Override
  public Optional<User> findById(Long id) {
    return Optional.empty();
  }

  @Override
  public Optional<User> findByEmail(String email) {
    return Optional.empty();
  }

  @Override
  public User save(User user) {
    return userRepository.save(UserEntity.fromModel(user)).toModel();
  }

  @Override
  public User update(User user) {
    return user;
  }
}
