package com.panda.back.user.infrastructure.gateway;

import com.panda.back.user.entity.model.User;
import com.panda.back.user.entity.model.UserStatus;
import com.panda.back.user.infrastructure.db.jpa.UserJpaEntity;
import com.panda.back.user.infrastructure.db.repository.UserJpaRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDataBaseGatewayImpl implements UserDataBaseGateway {

  private final UserJpaRepository userJpaRepository;

  @Override
  public User save(User user) {
    return userJpaRepository.save(UserJpaEntity.fromModel(user)).toModel();
  }

  @Override
  public Optional<User> findByIdAndStatus(Long id, UserStatus userStatus) {
    return userJpaRepository.findByIdAndStatus(id, userStatus).map(UserJpaEntity::toModel);
  }

  @Override
  public Optional<User> findByEmail(String email) {
    return userJpaRepository.findByEmail(email).map(UserJpaEntity::toModel);
  }
}
