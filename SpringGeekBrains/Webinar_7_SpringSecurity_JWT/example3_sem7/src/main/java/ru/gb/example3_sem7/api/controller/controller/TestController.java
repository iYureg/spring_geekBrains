package ru.gb.example3_sem7.api.controller.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.example3_sem7.service.JwtTokenService;

@RestController
public class TestController {

    private final JwtTokenService jwtTokenService;
    @Autowired
    public TestController(JwtTokenService jwtTokenService) {
        this.jwtTokenService = jwtTokenService;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> testEndpoint(HttpServletRequest request) {

        int userId = jwtTokenService.getUserIdFromToken(request);

        return new ResponseEntity<>("Hello, " + userId, HttpStatus.OK);
    }
}
