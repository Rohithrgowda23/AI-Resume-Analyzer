package com.ai.Resume.analyser.service;

import com.ai.Resume.analyser.dto.*;
import org.springframework.http.ResponseEntity;

public interface SecurityService {

    ResponseEntity<?> register(UserRegister reg);

    ResponseEntity<?> verifyEmail(VerifyEmailOtp verifyEmail);

    ResponseEntity<?> login(UserLogin req);

    ResponseEntity<?> sentResetOtp(ResetOtp req);

    ResponseEntity<?> verifyResetOtp(ResetOtpVerification req);

    ResponseEntity<?> resetAccountPassword(ResetPasscode req);
}