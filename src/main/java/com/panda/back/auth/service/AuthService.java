package com.panda.back.auth.service;

public interface AuthService {
    void sendEmail(String email);

    void verifyEmail(String email);

}
