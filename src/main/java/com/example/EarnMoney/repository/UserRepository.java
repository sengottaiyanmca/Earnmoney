package com.example.EarnMoney.repository;

import com.example.EarnMoney.model.Role;
import com.example.EarnMoney.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

