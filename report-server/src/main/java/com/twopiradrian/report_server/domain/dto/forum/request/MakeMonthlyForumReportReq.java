package com.twopiradrian.report_server.domain.dto.forum.request;

import com.twopiradrian.error.ErrorHandler;
import com.twopiradrian.error.ErrorType;
import lombok.Getter;

@Getter
public class MakeMonthlyForumReportReq {

    private final String token;

    private final Integer month;

    private final Integer year;

    private MakeMonthlyForumReportReq(String token, Integer month, Integer year) {
        this.token = token;
        this.month = month;
        this.year = year;
    }

    public static MakeMonthlyForumReportReq create(String token, Integer month, Integer year) {

        if (token == null || token.isEmpty()) {
            throw new ErrorHandler(ErrorType.UNAUTHORIZED);
        }

        if (month < 1 || month > 12) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        return new MakeMonthlyForumReportReq(token, month, year);
    }

}
