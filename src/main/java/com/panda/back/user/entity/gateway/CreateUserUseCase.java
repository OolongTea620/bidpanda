package com.panda.back.user.entity.gateway;

import com.panda.back.user.entity.model.User;
import com.panda.back.user.infrastructure.dto.CreateUserUseCaseDto;

public interface CreateUserUseCase {

  User create(CreateUserUseCaseDto createUserUseCaseDto);

}
