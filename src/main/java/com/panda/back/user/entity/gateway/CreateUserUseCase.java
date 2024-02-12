package com.panda.back.user.entity.gateway;

import com.panda.back.user.entity.model.User;
import com.panda.back.user.infrastructure.dto.UserCreateVo;
import org.springframework.stereotype.Service;

public interface CreateUserUseCase {
    User create(UserCreateVo userCreateVo);

}
