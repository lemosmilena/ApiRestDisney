package com.example.apirestdisney.controllers;


import com.example.apirestdisney.entities.MovieEntity;
import com.example.apirestdisney.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")

public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /** Listar todas las peliculas **/

    @GetMapping()
    public List<MovieEntity> findAll(){
        return movieService.findAll();
    }

    /** Listar pelicula por titulo **/

    @GetMapping("/title/{title}")
    public List<MovieEntity> findByTitle(@PathVariable String title){
        return movieService.findByTitle(title);
    }

    /** Buscar pelicula por ID **/

    @GetMapping("/id/{id}")
    public Optional<MovieEntity> findById(@PathVariable Integer id){
        return movieService.findById(id);
    }

    // TODO ordenar peliculas por orden ASC o DES

    /** Guardar pelicula **/

    @PostMapping(value = "/save", consumes = "application/json")
    public void saveMovie(@RequestBody MovieEntity movieEntity){
        movieService.save(movieEntity);
    }

    /** Eliminar pelicula por ID **/

    @DeleteMapping("/delete/{id}")
    public void deleteMovie(@PathVariable Integer id){
       movieService.deleteById(id);
    }



}
