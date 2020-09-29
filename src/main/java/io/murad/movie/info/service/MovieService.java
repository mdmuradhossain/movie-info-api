package io.murad.movie.info.service;

import java.util.concurrent.ExecutionException;

import io.murad.movie.info.model.Movie;

public interface MovieService {

	public String saveMovieInfo(Movie movie) throws InterruptedException, ExecutionException;
	public Movie getMovieInfoByName(String movieName) throws InterruptedException, ExecutionException;
	public String updateMovieInfo(Movie movie) throws InterruptedException, ExecutionException;
	public String deleteMovieInfoByName(String movieName) throws InterruptedException, ExecutionException;
	
}
