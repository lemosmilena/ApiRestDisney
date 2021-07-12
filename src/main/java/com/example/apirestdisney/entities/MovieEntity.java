package com.example.apirestdisney.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "movies")
public class MovieEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer movie_id;
    private String image_url;
    private String title;
    private Integer year;
    private Integer score;
    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY)
    private List<CharacterEntity> characters;
    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY)
    private List<GenreEntity> genres;

    public MovieEntity() {
    }

    public MovieEntity(String image_url, String title, Integer year, Integer score, List<CharacterEntity> characters) {
        this.image_url = image_url;
        this.title = title;
        this.year = year;
        this.score = score;
        this.characters = characters;
    }

    public MovieEntity(Integer movie_id, String image_url, String title, Integer year, Integer score, List<CharacterEntity> characters) {
        this.movie_id = movie_id;
        this.image_url = image_url;
        this.title = title;
        this.year = year;
        this.score = score;
        this.characters = characters;
    }

    public Integer getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Integer movie_id) {
        this.movie_id = movie_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer yearCreation) {
        this.year = yearCreation;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<CharacterEntity> getCharacters() {
        return characters;
    }

    public void setCharacters(List<CharacterEntity> characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "MovieEntity{" +
                "movie_id=" + movie_id +
                ", image_url='" + image_url + '\'' +
                ", title='" + title + '\'' +
                ", yearCreation=" + year +
                ", score=" + score +
                '}';
    }
}
