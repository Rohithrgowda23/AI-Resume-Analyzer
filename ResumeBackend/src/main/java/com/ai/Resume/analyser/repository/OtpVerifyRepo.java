package com.ai.Resume.analyser.repository;

import com.ai.Resume.analyser.entity.OtpVerify;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtpVerifyRepo extends JpaRepository<OtpVerify,String> {
}
