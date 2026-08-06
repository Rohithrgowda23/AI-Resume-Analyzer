package com.ai.Resume.analyser.repository;

import com.ai.Resume.analyser.entity.PreviousTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrevTableRepo extends JpaRepository<PreviousTable,String> {

}
