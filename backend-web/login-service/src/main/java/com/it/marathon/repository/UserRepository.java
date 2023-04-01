package com.it.marathon.repository;

import com.it.marathon.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    @Query(
            value = "SELECT * FROM users WHERE username = :username AND password = :password",
            nativeQuery = true
    )
    Optional<UserEntity> findUserByCredentials(String username, String password);
}
