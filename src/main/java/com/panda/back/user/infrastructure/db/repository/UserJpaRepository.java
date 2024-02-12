package com.panda.back.user.infrastructure.db.repository;


import com.panda.back.user.entity.model.UserStatus;
import com.panda.back.user.infrastructure.db.jpa.UserJpaEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserJpaEntity, Long> {

  Optional<UserJpaEntity> findByIdAndStatus(Long id, UserStatus status);

  Optional<UserJpaEntity> findByEmail(String email);
}
