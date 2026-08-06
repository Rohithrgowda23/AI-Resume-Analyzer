package com.ai.Resume.analyser.controller;

import com.ai.Resume.analyser.dto.ResetOtp;
import com.ai.Resume.analyser.dto.ResetOtpVerification;
import com.ai.Resume.analyser.dto.ResetPasscode;
import com.ai.Resume.analyser.dto.UserLogin;
import com.ai.Resume.analyser.dto.UserRegister;
import com.ai.Resume.analyser.dto.VerifyEmailOtp;
import com.ai.Resume.analyser.service.SecurityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resume-analyser/api/v1/auth")
@RequiredArgsConstructor
public class SecurityController {

    private final SecurityService securityService;

    @PostMapping("/verify-email")
    public ResponseEntity<?> verifyEmail(
            @Valid @RequestBody VerifyEmailOtp request) {

        return securityService.verifyEmail(request);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @Valid @RequestBody UserRegister request) {

        return securityService.register(request);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @Valid @RequestBody UserLogin request) {

        return securityService.login(request);
    }

    @PostMapping("/send-reset-otp")
    public ResponseEntity<?> sendResetOtp(
            @Valid @RequestBody ResetOtp request) {

        return securityService.sentResetOtp(request);
    }

    @PostMapping("/verify-reset-otp")
    public ResponseEntity<?> verifyResetOtp(
            @Valid @RequestBody ResetOtpVerification request) {

        return securityService.verifyResetOtp(request);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(
            @Valid @RequestBody ResetPasscode request) {

        return securityService.resetAccountPassword(request);
    }
}