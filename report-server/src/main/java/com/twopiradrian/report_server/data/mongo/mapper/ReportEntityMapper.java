package com.twopiradrian.report_server.data.mongo.mapper;

import com.twopiradrian.report_server.data.mongo.model.ReportModel;
import com.twopiradrian.report_server.domain.reports.Report;

public class ReportEntityMapper {

    public static Report toDomain(ReportModel reportModel) {
        return new Report(
            reportModel.getId(),
            reportModel.getType(),
            reportModel.getContent(),
            reportModel.getDate()
        );
    }

    public static ReportModel toModel(Report report) {
        return new ReportModel(
            report.getId(),
            report.getType(),
            report.getContent(),
            report.getDate()
        );
    }

}
