package com.panda.back.user.infrastructure.api.web;

import com.panda.back.user.entity.gateway.UserUseCase;
import com.panda.back.user.entity.model.User;
import com.panda.back.user.infrastructure.dto.DeleteUserDto;
import com.panda.back.user.infrastructure.dto.UpdateNickReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

  private final UserUseCase userUseCase;

  @PatchMapping("/nickname")
  public ResponseEntity<?> updateNickname(@RequestBody UpdateNickReqDto updateNickReqDto) {
    User user = userUseCase.updateNickname(updateNickReqDto);
    return ResponseEntity
        .ok()
        .body(new Object());
  }

  public ResponseEntity<?> cancel(@RequestBody DeleteUserDto deleteUserDto) {
    User user = userUseCase.delete(deleteUserDto);
    return ResponseEntity
        .ok()
        .body(new Object());
  }
}
