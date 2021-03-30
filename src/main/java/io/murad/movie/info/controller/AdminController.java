package io.murad.movie.info.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private static final String ADMIN = "Admin Page";
    @RequestMapping(value = "/index")
    public String admin(Principal principal){
        String name = principal.getName();
        return String.format("%s %s",ADMIN,name);
    }
}
