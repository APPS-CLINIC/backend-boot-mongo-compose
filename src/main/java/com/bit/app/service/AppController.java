package com.bit.app.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping({"/services/sample", "/internal/sample"})
public class AppController {

    @GetMapping(value = "/version")
    ResponseEntity<Version> queryTotalOpCy() {
        return Optional.of(Version.builder().version("bit.app.latest").build())
                .map(ResponseEntity::ok)
                .orElse(notFound().build());
    }

}
