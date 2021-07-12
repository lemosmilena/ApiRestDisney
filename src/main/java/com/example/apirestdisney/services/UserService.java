package com.example.apirestdisney.services;

import com.example.apirestdisney.entities.UserEntity;
import com.example.apirestdisney.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service

public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String crearToken(UserEntity userEntity) {
        Random numeroAleatorio = new Random();
        Integer numero = numeroAleatorio.nextInt(1000);
        String token = userEntity.getName() + numero;
        return token;
    }


    public void save(UserEntity userEntity) {
        userEntity.setApiCallsLimit(1000);
        userEntity.setToken(crearToken(userEntity));
        userRepository.save(userEntity);
    }
}
