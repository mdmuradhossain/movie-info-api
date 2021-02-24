package io.murad.movie.info.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.murad.movie.info.model.Movie;
import io.murad.movie.info.service.MovieService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController()
@RequestMapping("/api")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(path = "/movies")
    @ApiOperation(value ="Finds movie by id",notes = "Provide and id to look up specific movie from Movie Info App")
    public ResponseEntity<List<Movie>> getAllMovieInfo() {
        List<Movie> movies = movieService.getMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @PostMapping(path = "/movies")
    public ResponseEntity<Movie> saveMovieInfo(@RequestBody Movie movie) throws InterruptedException, ExecutionException {
        Movie saveMovie = movieService.saveMovieInfo(movie);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(saveMovie.getId()).toUri();
        return ResponseEntity.created(location).body(movie);
    }

    @GetMapping(path = "movies/{id}")
    public Movie getMovie(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @PutMapping(path = "/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) throws InterruptedException, ExecutionException {
        Movie movieInfo = movieService.getMovieById(id);
        movieInfo.setMovieName(movie.getMovieName());
        return new ResponseEntity<>(movieService.saveMovieInfo(movieInfo), HttpStatus.OK);
    }

    @DeleteMapping(path = "/movies/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id) throws InterruptedException, ExecutionException {
        Movie movie = movieService.getMovieById(id);
        movieService.deleteMovieInfo(movie);
        return ResponseEntity.ok().build();
    }
}
