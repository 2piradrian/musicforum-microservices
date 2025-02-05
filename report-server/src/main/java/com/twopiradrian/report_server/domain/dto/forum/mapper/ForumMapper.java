package com.twopiradrian.report_server.domain.dto.forum.mapper;

import com.twopiradrian.report_server.domain.dto.forum.implementation.MakeMonthlyForumReportMapper;

public class ForumMapper {

    public static MakeMonthlyForumReportMapper makeMonthlyReport() {
        return new MakeMonthlyForumReportMapper();
    }

}
