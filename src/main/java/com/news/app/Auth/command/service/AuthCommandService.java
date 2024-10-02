package com.news.app.Auth.command.service;

import com.news.app.Auth.shared.dto.AuthResponseDTO;
import com.news.app.Common.utils.JwtUtils;
import com.news.app.User.command.repository.UserCommandRepository;
import com.news.app.User.shared.dto.UserDTO;
import com.news.app.User.shared.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthCommandService {

    private final UserCommandRepository userCommandRepository;
    private final JwtUtils jwtUtils;

    @Transactional
    public AuthResponseDTO signUp(UserDTO request){
        UserEntity user = UserEntity.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .birthDate(request.getBirthDate())
                .role(request.getRole())
                .loggerAt(new Date())
                .updateAt(new Date())
                .createAt(new Date())
                .build();

        userCommandRepository.save(user);

        return AuthResponseDTO.builder()
                .token(jwtUtils.getToken(user))
                .build();
    }

}
