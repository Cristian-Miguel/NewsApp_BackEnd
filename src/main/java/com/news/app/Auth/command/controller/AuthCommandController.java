package com.news.app.Auth.command.controller;

import com.news.app.Auth.command.service.AuthCommandService;
import com.news.app.Auth.shared.dto.AuthResponseDTO;
import com.news.app.Common.dto.GenericResponse;
import com.news.app.User.shared.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.news.app.Common.constant.HttpMessage.CODE_200;
import static com.news.app.Common.constant.HttpMessage.CODE_201;

@RestController
@RequestMapping("/auth/write")
@RequiredArgsConstructor
public class AuthCommandController {

    private final AuthCommandService authCommandService;

    @PostMapping(value = "/sign_up")
    public ResponseEntity<GenericResponse<AuthResponseDTO>> SignUp(@RequestBody UserDTO request) {
        AuthResponseDTO token = authCommandService.signUp(request);
        GenericResponse<AuthResponseDTO> response = new GenericResponse<>(true, CODE_201.getMessage(), token);

        return ResponseEntity.status(CODE_201.getCode()).body(response);
    }

}
