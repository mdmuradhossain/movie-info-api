package io.murad.movie.info.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private static final String ADMIN = "Admin Page";
    @RequestMapping(value = "/index")
    public String admin(){
        return String.format("%s",ADMIN);
    }
}
