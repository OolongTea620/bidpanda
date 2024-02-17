package com.panda.back.user.adapter.in.web;

import com.panda.back.user.adapter.in.web.dto.CreateUserReq;
import com.panda.back.user.adapter.in.web.dto.CreateUserRes;
import com.panda.back.user.adapter.in.web.dto.VerifyEmailRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserRestController {

  @GetMapping("")
  public ResponseEntity<?> checkEmail() {
    return null;
  }

  @PostMapping("/verification/email")
  public ResponseEntity<VerifyEmailRes> verifyEmail(@PathVariable String email) {
    return null;
  }


  @PostMapping("")
  public ResponseEntity<CreateUserRes> create(@RequestBody CreateUserReq createUserReq) {
    return null;
  }
}
