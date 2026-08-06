package com.ai.Resume.analyser.service;

import jakarta.mail.MessagingException;

public interface MailService {

    void sentVerifyOtp(String username, String email, String otp)
            throws MessagingException;

    void sentResetOtp(String username, String email, String otp)
            throws MessagingException;

}