package com.example.apirestdisney.repositories;

import com.example.apirestdisney.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findUserByEmailandToken(String email, String token);

}
