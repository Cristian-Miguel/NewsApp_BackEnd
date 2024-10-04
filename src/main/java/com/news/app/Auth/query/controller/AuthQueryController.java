package com.news.app.Auth.query.controller;

import com.news.app.Auth.command.dto.UserSignInDTO;
import com.news.app.Auth.query.service.AuthQueryService;
import com.news.app.Auth.shared.dto.AuthResponseDTO;
import com.news.app.Common.dto.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.news.app.Common.constant.HttpMessage.CODE_200;

@RestController
@RequestMapping("/auth/read")
@RequiredArgsConstructor
public class AuthQueryController {

    private final AuthQueryService authQueryService;

    @PostMapping(value = "/sign_in")
    public ResponseEntity<GenericResponse<AuthResponseDTO>> SignIn(@RequestBody UserSignInDTO request) {
        AuthResponseDTO token = authQueryService.signIn(request);
        GenericResponse<AuthResponseDTO> response = new GenericResponse<>(true, CODE_200.getMessage(), token);

        return ResponseEntity.ok(response);
    }

}
