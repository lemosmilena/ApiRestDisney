package com.example.apirestdisney.services;

import com.example.apirestdisney.entities.CharacterEntity;
import com.example.apirestdisney.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<CharacterEntity> findAll(){
        return characterRepository.findAll();
    }

    public List<CharacterEntity> findByName(String name) {
        return characterRepository.findByNameContaining(name);
    }

    public Optional<CharacterEntity> findById(Integer id) {
        return characterRepository.findById(id); }

    public List<CharacterEntity> findByWeight(Integer weight){
        return characterRepository.findAllByWeightContaining(weight);}

    public List<CharacterEntity> findByAge(Integer age) {
        return characterRepository.findCharacterEntitiesByAge(age);}

    public void save(CharacterEntity characterEntity) {
        characterRepository.save(characterEntity);
    }

    public void deleteById(Integer id) {
        if(!characterRepository.existsById(id))
            throw new IllegalStateException("El personaje no existe!");
        characterRepository.deleteById(id);
    }

}
