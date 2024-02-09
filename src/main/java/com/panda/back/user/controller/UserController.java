package com.panda.back.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/users")
public class UserController {
    @PostMapping("/exists/{email}")
    public void existsEmail(@PathVariable String email) {

    }

    public void verifyEmail() {

    }

    public void getById() {

    }
}
