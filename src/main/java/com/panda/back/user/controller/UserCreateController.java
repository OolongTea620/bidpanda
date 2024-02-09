package com.panda.back.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserCreateController {
    @PostMapping("")
    public void create() {
    }
    @PostMapping("/kakao")
    public void createByKakao() {
        return;
    }

}
