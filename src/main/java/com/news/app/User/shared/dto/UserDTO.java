package com.news.app.User.shared.dto;

import com.news.app.Common.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    Long id;
    String uuid;
    String email;
    String username;
    String firstName;
    String lastName;
    Date createDate;
    Date lastLogger;
    Date lastUpdate;
    Roles role;
    String password;
    Date birthDate;

}
