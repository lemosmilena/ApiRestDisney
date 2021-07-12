package com.example.apirestdisney.repositories;

import com.example.apirestdisney.entities.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface GenreRepository extends JpaRepository<GenreEntity, Integer> {
}
