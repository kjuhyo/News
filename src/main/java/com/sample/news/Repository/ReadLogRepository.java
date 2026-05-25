package com.sample.news.Repository;

import com.sample.news.Entity.ReadLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadLogRepository extends JpaRepository<ReadLog, Long> {
    List<ReadLog> findAll();
}