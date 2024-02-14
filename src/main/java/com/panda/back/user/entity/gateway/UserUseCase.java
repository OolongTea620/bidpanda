package com.panda.back.user.entity.gateway;

import com.panda.back.user.entity.model.User;
import com.panda.back.user.infrastructure.dto.DeleteUserDto;
import com.panda.back.user.infrastructure.dto.UpdateNickReqDto;

public interface UserUseCase {

  User updateNickname(UpdateNickReqDto updateNickReqDto);

  User delete(DeleteUserDto deleteUserDto);
}
