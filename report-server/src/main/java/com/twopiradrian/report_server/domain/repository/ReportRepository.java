package com.twopiradrian.report_server.domain.repository;


import com.twopiradrian.report_server.domain.reports.Report;

public interface ReportRepository {

    Report save(Report report);

}
