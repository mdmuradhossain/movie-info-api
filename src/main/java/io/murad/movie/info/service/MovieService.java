package io.murad.movie.info.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import io.murad.movie.info.model.Movie;

public interface MovieService {

	public Movie saveMovieInfo(Movie movie) throws InterruptedException, ExecutionException;
	public Optional<Movie> getMovieById(Long id);
	public List<Movie> getMovies();
	public void deleteMovieInfo(Movie movie);

}
