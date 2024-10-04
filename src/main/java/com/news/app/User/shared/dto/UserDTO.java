package com.news.app.User.shared.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.news.app.Common.constant.Roles;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UUID;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    Long id;

    @UUID
    String uuid;

    @Email
    @NotBlank
    String email;

    @NotBlank
    @Size(min=8, max = 16)
    String password;

    @NotBlank
    String username;

    @NotBlank
    String firstName;

    @NotBlank
    String lastName;

    @NotBlank
    Roles role;

    @NotBlank
    Date birthDate;

}
