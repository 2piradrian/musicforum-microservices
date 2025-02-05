package com.twopiradrian.report_server.domain.dto.forum.response;

import com.twopiradrian.report_server.domain.reports.forum.MonthlyForums;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MakeMonthlyForumReportRes {

    private final String id;

    private final MonthlyForums report;

}
