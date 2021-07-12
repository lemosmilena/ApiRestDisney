package com.example.apirestdisney.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name ="genres")

public class GenreEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer genre_id;
    private String name;
    private String image_url;
    @ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable (name = "genres_x_movies",
        joinColumns = @JoinColumn(name = "genre_id"),
        inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<MovieEntity> movies;


    public GenreEntity() {
    }

    public GenreEntity(String name, String image_url, List<MovieEntity> movies) {
        this.name = name;
        this.image_url = image_url;
        this.movies = movies;
    }

    public GenreEntity(Integer genre_id, String name, String image_url, List<MovieEntity> movies) {
        this.genre_id = genre_id;
        this.name = name;
        this.image_url = image_url;
        this.movies = movies;
    }

    public Integer getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Integer genre_id) {
        this.genre_id = genre_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public List<MovieEntity> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieEntity> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "GenreEntity{" +
                "genre_id=" + genre_id +
                ", name='" + name + '\'' +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}
