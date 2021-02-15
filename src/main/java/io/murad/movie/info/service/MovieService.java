package io.murad.movie.info.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import io.murad.movie.info.model.Movie;

public interface MovieService {

	public Movie saveMovieInfo(Movie movie) throws InterruptedException, ExecutionException;
	public Movie getMovieById(Long id);
	public List<Movie> getMovies();
//	public Movie getMovieInfoByName(String movieName) throws InterruptedException, ExecutionException;
//	public String updateMovieInfo(Movie movie) throws InterruptedException, ExecutionException;
//	public String deleteMovieInfoByName(String movieName) throws InterruptedException, ExecutionException;
	public void deleteMovieInfo(Movie movie);

}
