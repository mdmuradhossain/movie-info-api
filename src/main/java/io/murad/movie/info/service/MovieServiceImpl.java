package io.murad.movie.info.service;

import io.murad.movie.info.model.Movie;
import io.murad.movie.info.repository.MovieRepository;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
public class MovieServiceImpl implements MovieService {

    private final Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);
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

    @Override
    public void deleteMovieInfo(Movie movie) {
        movieRepository.delete(movie);
        log.info("deleted "+movie.getMovieName());
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
