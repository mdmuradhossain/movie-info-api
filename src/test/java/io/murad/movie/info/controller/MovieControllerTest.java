package io.murad.movie.info.controller;

import static org.mockito.Mockito.when;

import io.murad.movie.info.model.Movie;
import io.murad.movie.info.service.MovieService;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {MovieController.class})
@ExtendWith(SpringExtension.class)
public class MovieControllerTest {
    @Autowired
    private MovieController movieController;

    @MockBean
    private MovieService movieService;

    @Test
    public void testGetAllMovieInfo() throws Exception {

        when(this.movieService.getMovies()).thenReturn(new ArrayList<Movie>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/movies");
        MockMvcBuilders.standaloneSetup(this.movieController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

}

