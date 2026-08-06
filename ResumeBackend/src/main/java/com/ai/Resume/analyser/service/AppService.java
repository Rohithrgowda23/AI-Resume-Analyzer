package com.ai.Resume.analyser.service;

import org.apache.tika.exception.TikaException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AppService {

    ResponseEntity<?> extract(String roles,
                              String jobDescription,
                              MultipartFile file)
            throws TikaException, IOException, InterruptedException;

    ResponseEntity<?> lastReport();

    ResponseEntity<?> logout();

    ResponseEntity<?> deleteAccount();

    ResponseEntity<?> tokenValidation();
}
