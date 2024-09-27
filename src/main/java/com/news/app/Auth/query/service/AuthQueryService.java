package com.news.app.Auth.query.service;

import com.news.app.Auth.command.dto.UserSignInDTO;
import com.news.app.Auth.shared.dto.AuthDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthQueryService {

    public AuthDTO signIn(UserSignInDTO request){

        return null;
    }

}
