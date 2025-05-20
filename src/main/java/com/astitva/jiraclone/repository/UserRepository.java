package com.astitva.jiraclone.repository;

import com.astitva.jiraclone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository  // optional but good practice
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
