package com.ai.Resume.analyser.controller;

import com.ai.Resume.analyser.service.AppService;
import lombok.RequiredArgsConstructor;
import org.apache.tika.exception.TikaException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/resume-analyser/api/v1")
@RequiredArgsConstructor
public class AppController {

    private final AppService appService;

    @PostMapping("/extract")
    public ResponseEntity<?> extractResume(
            @RequestParam("roles") String roles,
            // NEW: optional Job Description field. `required = false` + a default of ""
            // means any existing frontend that never sends this field keeps working exactly
            // as before - Job Role alone still drives resume scoring in that case.
            @RequestParam(value = "jobDescription", required = false, defaultValue = "") String jobDescription,
            @RequestParam("file") MultipartFile file)
            throws TikaException, IOException, InterruptedException {

        return appService.extract(roles, jobDescription, file);
    }

    @GetMapping("/last-report")
    public ResponseEntity<?> getLastReport() {
        return appService.lastReport();
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        return appService.logout();
    }

    @DeleteMapping("/delete-account")
    public ResponseEntity<?> deleteAccount() {
        return appService.deleteAccount();
    }

    @PostMapping("/validate-token")
    public ResponseEntity<?> validateToken() {
        return appService.tokenValidation();
    }
}
