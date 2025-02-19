package com.twopiradrian.auth_server.domain.dto.user.request;

import com.twopiradrian.error.ErrorHandler;
import com.twopiradrian.error.ErrorType;
import lombok.Getter;

@Getter
public class AuthUserReq {

    private final String token;

    private AuthUserReq(String token) {
        this.token = token;
    }

    public static AuthUserReq create(String token) {

        if (token == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        return new AuthUserReq(token);
    }
}
