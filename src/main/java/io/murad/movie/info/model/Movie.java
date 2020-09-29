package io.murad.movie.info.model;


public class Movie {

	private Long id;
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
