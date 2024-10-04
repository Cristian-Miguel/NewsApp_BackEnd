package com.news.app.Common.constant;

import lombok.Getter;

@Getter
public enum ErrorMessage {
    EMAIL_ALREDY_EXIST("Email address was already created in the system."),
    USERNAME_ALREDY_EXIST("Username address was already created in the system."),
    USER_NOT_FOUNT("User wasn't found.");

    private String message;

    private ErrorMessage(String message){
        this.message = message;
    }
}
