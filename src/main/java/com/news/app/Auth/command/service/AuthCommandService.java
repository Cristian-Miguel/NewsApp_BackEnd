package com.news.app.Auth.command.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.news.app.Auth.shared.dto.AuthResponseDTO;
import com.news.app.Common.utils.JwtUtils;
import com.news.app.User.command.event.UserCreatedEvent;
import com.news.app.User.command.repository.UserCommandRepository;
import com.news.app.User.shared.dto.UserDTO;
import com.news.app.User.shared.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthCommandService {

    private final UserCommandRepository userCommandRepository;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public AuthResponseDTO signUp(UserDTO request) {
        UserEntity user = UserEntity.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .birthDate(request.getBirthDate())
                .role(request.getRole())
                .loggerAt(new Date())
                .updateAt(new Date())
                .createAt(new Date())
                .build();

        userCommandRepository.save(user);

        eventPublisher.publishEvent(new UserCreatedEvent(user.getUsername(), user.getEmail()));

        return AuthResponseDTO.builder()
                .token(jwtUtils.getToken(user))
                .build();
    }

}
