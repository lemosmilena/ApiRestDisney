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

    public String login(String email, String token) {
        UserEntity userEntity = userRepository.findUserByEmailandToken(email, token);
        if(userEntity != null){
            userEntity.setTokenTemporal(String.valueOf((Math.round(Math.random()+1000)+1)));
            userRepository.save(userEntity);
            return userEntity.getTokenTemporal();
        }
        return "Error de acceso";
    }

    public boolean valiteTemporalAndCountApiCall(String email, String tokenTemporal) {
        UserEntity userEntity = userRepository.findUserByEmailandToken(email, tokenTemporal);
        if(userEntity!= null && userEntity.getApiCallsAvailable()>0){
            userEntity.descontarCall();
            userRepository.save(userEntity);
        }
        return false;
    }
}
