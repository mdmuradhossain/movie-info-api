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
@CrossOrigin(origins = "http://localhost:8080")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(path = "/movies")
    @ApiOperation(value = "Finds movie by id", notes = "Provide and id to look up specific movie from Movie Info App")
    public ResponseEntity<List<Movie>> getAllMovieInfo() {
        List<Movie> movies = movieService.getMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @PostMapping(path = "/movies", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Movie> saveMovieInfo(@RequestBody Movie movie) throws InterruptedException, ExecutionException {
        Movie saveMovie = movieService.saveMovieInfo(movie);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(saveMovie.getId()).toUri();
        /*Return only this is same with @ResponseStatus(HttpStatus.CREATED)
         *return movieService.saveMovieInfo(movie);
         *No need ResponseEntity*/
        return ResponseEntity.created(location).body(movie);
    }

    @GetMapping(path = "movies/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        Optional<Movie> movie = movieService.getMovieById(id);
        return movie.map(film -> new ResponseEntity<>(film, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PutMapping(path = "/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) throws InterruptedException, ExecutionException {
        Optional<Movie> movieInfo = movieService.getMovieById(id);
        movieInfo.get().setMovieName(movie.getMovieName());
        return new ResponseEntity<>(movieService.saveMovieInfo(movieInfo.get()), HttpStatus.OK);
    }

    @DeleteMapping(path = "/movies/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteMovie(@PathVariable Long id) throws InterruptedException, ExecutionException {
        Optional<Movie> movie = movieService.getMovieById(id);
        Movie rmMovie = movie.get();
        movieService.deleteMovieInfo(rmMovie);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
