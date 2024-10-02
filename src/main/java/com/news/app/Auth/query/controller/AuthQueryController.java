package com.news.app.Auth.query.controller;

import com.news.app.Auth.command.dto.UserSignInDTO;
import com.news.app.Auth.query.service.AuthQueryService;
import com.news.app.Auth.shared.dto.AuthResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/read")
@RequiredArgsConstructor
public class AuthQueryController {

    private final AuthQueryService authQueryService;

    @PostMapping(value = "/sign_in")
    public ResponseEntity<AuthResponseDTO> SignIn(@RequestBody UserSignInDTO request) {

        return ResponseEntity.ok(authQueryService.signIn(request));
    }

}
