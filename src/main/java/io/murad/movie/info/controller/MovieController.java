package io.murad.movie.info.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.murad.movie.info.model.Movie;
import io.murad.movie.info.service.MovieService;

@RestController()
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
    public Movie getMovie(@PathVariable Long id){
        return movieService.getMovieById(id);
    }
//    @PutMapping("/updateMovieInfo")
//    public String updatePatient(@RequestBody Movie movie) throws InterruptedException, ExecutionException {
//        return movieService.updateMovieInfo(movie);
//    }
//
//    @DeleteMapping("/deleteMovieInfo")
//    public String deletePatient(@RequestParam String moviename) throws InterruptedException, ExecutionException{
//        return movieService.deleteMovieInfoByName(moviename);
//    }
}
