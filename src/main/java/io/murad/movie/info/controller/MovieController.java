package io.murad.movie.info.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.murad.movie.info.model.Movie;
import io.murad.movie.info.service.MovieService;

@RestController
public class MovieController {

	@Autowired
    private MovieService movieService;

    @GetMapping("/getMovieInfo")
    public Movie getPatient(@RequestParam String moviename) throws InterruptedException, ExecutionException{
        return movieService.getMovieInfoByName(moviename);
    }

    @PostMapping("/storeMovieInfo")
    public String createPatient(@RequestBody Movie movie) throws InterruptedException, ExecutionException {
        return movieService.saveMovieInfo(movie);
    }

    @PutMapping("/updateMovieInfo")
    public String updatePatient(@RequestBody Movie movie) throws InterruptedException, ExecutionException {
        return movieService.updateMovieInfo(movie);
    }

    @DeleteMapping("/deleteMovieInfo")
    public String deletePatient(@RequestParam String moviename) throws InterruptedException, ExecutionException{
        return movieService.deleteMovieInfoByName(moviename);
    }
}
