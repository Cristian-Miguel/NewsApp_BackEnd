package com.news.app.Common.constant;

import lombok.Getter;

@Getter
public enum HttpMessage {
    CODE_200(200, "Success transaction."),
    CODE_201(201, "The component was created successful."),
    CODE_400(400, "Error in the request."),
    CODE_401(401, "Error in your authentication."),
    CODE_403(403, "The server is unable to return a response."),
    CODE_404(404, "The data wasn't found."),
    CODE_500(500, "Internal server error.");

    private int code;
    private String message;

    private HttpMessage( int code, String message ){
        this.code = code;
        this.message = message;
    }
}
