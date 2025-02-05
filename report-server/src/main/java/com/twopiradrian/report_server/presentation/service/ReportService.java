package com.twopiradrian.report_server.presentation.service;

import com.twopiradrian.report_server.domain.dto.forum.request.MakeMonthlyForumReportReq;
import com.twopiradrian.report_server.domain.dto.forum.response.MakeMonthlyForumReportRes;

public interface ReportService {

    MakeMonthlyForumReportRes makeMonthlyForumReport(MakeMonthlyForumReportReq dto);

}
