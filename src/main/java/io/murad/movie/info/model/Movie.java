package io.murad.movie.info.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table
@ApiModel(description = "Information about the Movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @ApiModelProperty(notes = "The unique id of the movie")
    private Long id;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "director_name")
    private String directorName;

    @Column(name = "release_country", nullable = true)
    private String releaseCountry;

    @Column(name = "imdb_rating")
    @JsonIgnore
    private Double imdbRating;

    @Column(name = "language", nullable = true)
    private String language;
    
    @Column(name = "trailer_link")
    private String trailerLink;

    @Column(name = "release_date", nullable = true)
    @JsonFormat(pattern = "mm-dd-yyyy")
    private Date releaseDate;

    @NotEmpty
    @Column(name = "movie_name")
    private String movieName;

    public Movie() {

    }

    public Movie(Long id, String description, String directorName, String releaseCountry, double imdbRating, String language, String trailerLink, Date releaseDate, @NotEmpty String movieName) {
        this.id = id;
        this.description = description;
        this.directorName = directorName;
        this.releaseCountry = releaseCountry;
        this.imdbRating = imdbRating;
        this.language = language;
        this.trailerLink = trailerLink;
        this.releaseDate = releaseDate;
        this.movieName = movieName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseCountry() {
        return releaseCountry;
    }

    public void setReleaseCountry(String releaseCountry) {
        this.releaseCountry = releaseCountry;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTrailerLink() {
        return trailerLink;
    }

    public void setTrailerLink(String trailerLink) {
        this.trailerLink = trailerLink;
    }
}
