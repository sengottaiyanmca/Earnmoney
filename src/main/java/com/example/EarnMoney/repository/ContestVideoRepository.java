package com.example.EarnMoney.repository;

import com.example.EarnMoney.model.ContestVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContestVideoRepository extends JpaRepository<ContestVideo, Long> {
    // Add custom query methods if needed
}

