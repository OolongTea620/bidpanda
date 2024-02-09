package com.panda.back.user.infrastucture.repository;

import com.panda.back.user.infrastucture.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
}
