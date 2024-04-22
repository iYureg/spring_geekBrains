package ru.gb.example3_sem7.api.controller.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.example3_sem7.api.dto.UserDTO;
import ru.gb.example3_sem7.service.JwtTokenService;
import ru.gb.example3_sem7.service.LoginService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenService jwtTokenService;
    private final LoginService loginService;

    public AuthController(JwtTokenService jwtTokenService,LoginService loginService) {
        this.jwtTokenService = jwtTokenService;
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO) {
        return loginService.login(userDTO)
                .map(userId -> {
                     String token = jwtTokenService.generateToken(userId, "USER");
                     return new ResponseEntity<>("Bearer " + token, HttpStatus.OK);
                }).orElseGet(() -> new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED));
    }

}
