package com.panda.back.user.service;

import com.panda.back.user.controller.port.in.UserCreate;
import com.panda.back.user.domain.User;
import com.panda.back.user.infrastucture.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Transactional
    public User create(UserCreate userCreate) {
        User user = User.from(userCreate);
        userRepository.save(user);

        return user;
    }
}
