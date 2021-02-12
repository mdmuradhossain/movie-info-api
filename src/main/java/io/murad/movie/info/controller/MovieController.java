package io.murad.movie.info.controller;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.murad.movie.info.model.Movie;
import io.murad.movie.info.service.MovieService;

@RestController()
@RequestMapping("/api")
public class MovieController {

    @Autowired
    private MovieService movieService;

//    @GetMapping("/getMovieInfo")
//    public Movie getPatient(@RequestParam String moviename) throws InterruptedException, ExecutionException{
//        return movieService.getMovieInfoByName(moviename);
//    }

    @PostMapping(path = "/movies")
    public Movie saveMovieInfo(@RequestBody Movie movie) throws InterruptedException, ExecutionException {
        return movieService.saveMovieInfo(movie);
    }

    @GetMapping(path = "movies/{id}")
    public Movie getMovie(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) throws InterruptedException, ExecutionException {
       Movie movieInfo = movieService.getMovieById(id);
        movieInfo.setMovieName(movie.getMovieName());
        return new ResponseEntity<>(movieService.saveMovieInfo(movieInfo), HttpStatus.OK);
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id) throws InterruptedException, ExecutionException{
        Movie movie = movieService.getMovieById(id);
        movieService.deleteMovieInfo(movie);
        return ResponseEntity.ok().build();
    }
}
