package com.fda.inv.repo;

import com.fda.inv.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

/**
 * Creada por Rober Molina
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String userName);
}