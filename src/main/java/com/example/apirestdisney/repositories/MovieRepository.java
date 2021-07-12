package com.example.apirestdisney.repositories;

import com.example.apirestdisney.entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {


    List<MovieEntity> findByTitleContaining(String title);

}
