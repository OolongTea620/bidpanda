package com.panda.back.user.infrastructure.api.web;

import com.panda.back.user.entity.gateway.CreateUserUseCase;
import com.panda.back.user.entity.model.User;
import com.panda.back.user.infrastructure.dto.UserCreateReqDto;
import com.panda.back.user.infrastructure.dto.UserCreateResVo;
import com.panda.back.user.infrastructure.dto.UserCreateVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class CreateUserController {

  private final CreateUserUseCase createUserUseCase;


  @PostMapping("/web")
  public ResponseEntity<UserCreateResVo> create(@RequestBody UserCreateReqDto userCreateReqDto) {
    User user = createUserUseCase.create(UserCreateVo.from(userCreateReqDto));
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(UserCreateResVo.from(user));
  }
}
