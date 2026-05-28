package com.javaScrpit.Pc2.controller;

import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<Void> home() {
        return ResponseEntity.status(302)
            .location(URI.create("/index.html"))
            .build();
    }
}