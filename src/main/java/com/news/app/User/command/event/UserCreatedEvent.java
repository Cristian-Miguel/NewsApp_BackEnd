package com.news.app.User.command.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class UserCreatedEvent {

    private final String username;
    private final String email;

}
