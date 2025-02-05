package com.twopiradrian.report_server.data.repository;

import com.twopiradrian.report_server.data.mongo.mapper.ReportEntityMapper;
import com.twopiradrian.report_server.data.mongo.model.ReportModel;
import com.twopiradrian.report_server.data.mongo.repository.MongoReportRepository;
import com.twopiradrian.report_server.domain.reports.Report;
import com.twopiradrian.report_server.domain.repository.ReportRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ReportRepositoryI implements ReportRepository {

    private final MongoReportRepository reportRepository;

    @Override
    public Report save(Report report) {
        ReportModel reportModel = ReportEntityMapper.toModel(report);
        ReportModel savedReportModel = this.reportRepository.save(reportModel);

        return ReportEntityMapper.toDomain(savedReportModel);
    }

}
