package com.sunny.SmartFinTrack.repository;

import com.sunny.SmartFinTrack.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String Email);
    Optional<UserEntity> findByEmailAndPassword(String Email, String Password);
}
