package io.murad.movie.info.model;

import javax.persistence.*;

@Entity
@Table
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "movie_name")
	private String movieName;
	public Movie() {
	
	}
	public Movie(Long id, String movieName) {

		this.id = id;
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
	
	
}
