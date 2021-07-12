package com.example.apirestdisney.services;

import com.example.apirestdisney.entities.MovieEntity;
import com.example.apirestdisney.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieEntity> findAll() {
        return movieRepository.findAll();
    }

    public List<MovieEntity> findByTitle(String title){
        return movieRepository.findByTitleContaining(title);
    }

    public Optional<MovieEntity> findById(Integer id) {
        return movieRepository.findById(id);
    }

    public void save(MovieEntity movieEntity) {
        movieRepository.save(movieEntity);
    }

    public void deleteById(Integer id) {
        if(!movieRepository.existsById(id))
            throw new IllegalStateException("La pelicula no existe.");
        movieRepository.deleteById(id);
    }
}
