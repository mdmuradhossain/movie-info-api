package io.murad.movie.info.service;

import io.murad.movie.info.model.Movie;
import io.murad.movie.info.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie saveMovieInfo(Movie movie) {
        log.info("saving movie info...");
        return movieRepository.save(movie);
    }

    @Override
    public Optional<Movie> getMovieById(Long id) {
        log.info("movie id: " + id);
        return movieRepository.findById(id);
    }

    @Override
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @Override
    public void deleteMovieInfo(Movie movie) {
        movieRepository.delete(movie);
        log.info("deleted " + movie.getMovieName());
    }

}
