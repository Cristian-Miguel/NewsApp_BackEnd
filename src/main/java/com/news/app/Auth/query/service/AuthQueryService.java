package com.news.app.Auth.query.service;

import com.news.app.Auth.command.dto.UserSignInDTO;
import com.news.app.Auth.shared.dto.AuthResponseDTO;
import com.news.app.Common.constant.ErrorMessage;
import com.news.app.Common.utils.JwtUtils;
import com.news.app.User.query.repository.UserQueryRepository;
import com.news.app.User.shared.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthQueryService {

    private final UserQueryRepository userQueryRepository;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public AuthResponseDTO signIn(UserSignInDTO request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));

        UserEntity userDetails = userQueryRepository.findByUsername(
                request.getUsername()
        ).orElseThrow(() -> new UsernameNotFoundException(ErrorMessage.USER_NOT_FOUNT.getMessage()));

        String token = jwtUtils.getToken(userDetails);

        return AuthResponseDTO.builder().token(token).build();
    }

}
