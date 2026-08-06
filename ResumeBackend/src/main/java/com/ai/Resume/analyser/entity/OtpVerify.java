package com.ai.Resume.analyser.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OtpVerify {

    @Id
    private String email;
    private String verifyOtp;
    private Date verifyExpiration;


}
