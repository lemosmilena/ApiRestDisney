package com.example.apirestdisney.repositories;

import com.example.apirestdisney.entities.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CharacterRepository extends JpaRepository<CharacterEntity, Integer> {

    List<CharacterEntity> findByNameContaining(String name);

    List<CharacterEntity> findAllByWeightContaining(Integer weight);

    List<CharacterEntity> findCharacterEntitiesByAge(Integer age);

}
