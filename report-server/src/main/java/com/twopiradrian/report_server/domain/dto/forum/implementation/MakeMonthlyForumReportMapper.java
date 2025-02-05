package com.twopiradrian.report_server.domain.dto.forum.implementation;

import com.twopiradrian.report_server.domain.dto.forum.request.MakeMonthlyForumReportReq;
import com.twopiradrian.report_server.domain.dto.forum.response.MakeMonthlyForumReportRes;
import com.twopiradrian.report_server.domain.reports.forum.MonthlyForums;

import java.util.Map;

public class MakeMonthlyForumReportMapper {

    public MakeMonthlyForumReportReq toRequest(String token, Integer month, Integer year) {
        return MakeMonthlyForumReportReq.create(
                token,
                month,
                year
        );
    }

    public MakeMonthlyForumReportRes toResponse(String id, MonthlyForums report) {
        return new MakeMonthlyForumReportRes(
                id,
            report
        );
    }

}
