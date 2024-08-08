package ru.netology.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.enums.Authorities;
import ru.netology.model.User;
import ru.netology.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(User user) {
        return service.getAuthorities(user);
    }
}

//    @GetMapping("/error")
//    private String error() {
//        throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT);
//    }
