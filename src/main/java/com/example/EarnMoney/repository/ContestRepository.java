package com.example.EarnMoney.repository;

import com.example.EarnMoney.model.Contest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContestRepository extends JpaRepository<Contest, Long> {
    // Find contest by name (custom query method)
    Optional<Contest> findByName(String name);

    // Add more custom query methods if needed
}
