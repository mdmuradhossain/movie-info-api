package io.murad.movie.info.service;

import io.murad.movie.info.model.Movie;
import io.murad.movie.info.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class MovieServiceImpl implements MovieService {


    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie saveMovieInfo(Movie movie) throws InterruptedException, ExecutionException {
        return movieRepository.save(movie);
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).get();
    }

//    @Override
//    public Movie getMovieInfoByName(String movieName) throws InterruptedException, ExecutionException {
//        return null;
//    }
//
//    @Override
//    public String updateMovieInfo(Movie movie) throws InterruptedException, ExecutionException {
//        return null;
//    }
//
//    @Override
//    public String deleteMovieInfoByName(String movieName) throws InterruptedException, ExecutionException {
//        return null;
//    }
}
