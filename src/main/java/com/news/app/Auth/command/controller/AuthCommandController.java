package com.news.app.Auth.command.controller;

import com.news.app.Auth.command.service.AuthCommandService;
import com.news.app.Auth.shared.dto.AuthResponseDTO;
import com.news.app.User.shared.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/write")
@RequiredArgsConstructor
public class AuthCommandController {

    private final AuthCommandService authCommandService;

    @PostMapping(value = "/sign_up")
    public ResponseEntity<AuthResponseDTO> SignUp(@RequestBody UserDTO request) {

        return ResponseEntity.ok(authCommandService.signUp(request));
    }

}
