package com.twopiradrian.forum_server.domain.dto.forum.request;

import com.twopiradrian.error.ErrorHandler;
import com.twopiradrian.error.ErrorType;
import lombok.Getter;

@Getter
public class GetMonthlyForumsReq {

    private final String token;

    private final Integer month;

    private final Integer year;

    private GetMonthlyForumsReq(String token, Integer month, Integer year) {
        this.token = token;
        this.month = month;
        this.year = year;
    }

    public static GetMonthlyForumsReq create(String token, Integer month, Integer year) {

        if (token == null || month == null || year == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        if (month < 1 || month > 12) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        if (year < 0) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        return new GetMonthlyForumsReq(token, month, year);
    }

}
