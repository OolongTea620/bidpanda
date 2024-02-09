package com.panda.back.user.infrastucture.repository;


import com.panda.back.user.domain.User;
import com.panda.back.user.domain.UserStatus;
import com.panda.back.user.infrastucture.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository userJpaRepository;

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public Optional<User> findByIdAndStatus(Long id, UserStatus userStatus) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        return userJpaRepository.save(UserEntity.from(user)).toModel();
    }
}
