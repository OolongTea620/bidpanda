package com.panda.back.user.infrastructure.api.web;

import com.panda.back.user.entity.gateway.CreateUserUseCase;
import com.panda.back.user.entity.model.User;
import com.panda.back.user.infrastructure.dto.CreateUserReqDto;
import com.panda.back.user.infrastructure.dto.CreateUserResDto;
import com.panda.back.user.infrastructure.dto.CreateUserUseCaseDto;
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
  public ResponseEntity<CreateUserResDto> create(@RequestBody CreateUserReqDto createUserReqDto) {
    User user = createUserUseCase.create(CreateUserUseCaseDto.from(createUserReqDto));
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(CreateUserResDto.from(user));
  }
}
