package com.twopiradrian.report_server.presentation.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twopiradrian.entity.Category;
import com.twopiradrian.entity.Forum;
import com.twopiradrian.error.ErrorHandler;
import com.twopiradrian.error.ErrorType;
import com.twopiradrian.report_server.data.repository.ForumRepositoryI;
import com.twopiradrian.report_server.data.repository.ReportRepositoryI;
import com.twopiradrian.report_server.domain.dto.forum.mapper.ForumMapper;
import com.twopiradrian.report_server.domain.dto.forum.request.MakeMonthlyForumReportReq;
import com.twopiradrian.report_server.domain.dto.forum.response.MakeMonthlyForumReportRes;
import com.twopiradrian.report_server.domain.reports.Report;
import com.twopiradrian.report_server.domain.reports.ReportType;
import com.twopiradrian.report_server.domain.reports.forum.MonthlyForums;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ReportServiceI implements ReportService {

    private final ForumRepositoryI forumRepository;
    private final ReportRepositoryI reportRepository;

    private final ObjectMapper objectMapper;

    @Override
    public MakeMonthlyForumReportRes makeMonthlyForumReport(MakeMonthlyForumReportReq dto) {
        var forums = this.forumRepository.getMonthlyForums(dto.getToken(), dto.getMonth(), dto.getYear());

        if (forums == null || forums.isEmpty()) {
            throw new ErrorHandler(ErrorType.FORUM_NOT_FOUND);
        }

        MonthlyForums report = new MonthlyForums();
        report.setMonth(dto.getMonth());
        report.setYear(dto.getYear());

        Integer totalForums = forums.size();
        report.setTotalForums(totalForums);

        Map<Category, Integer> forumsByCategory = forums.stream()
                .collect(Collectors.groupingBy(Forum::getCategory, Collectors.summingInt(forum -> 1)));
        report.setForumsByCategory(forumsByCategory);

        Map<Category, Integer> viewsByCategory = forums.stream()
                .collect(Collectors.groupingBy(Forum::getCategory, Collectors.summingInt(Forum::getViews)));
        report.setViewsByCategory(viewsByCategory);

        Report reportJson = new Report();
        reportJson.setContent(this.objectMapper.valueToTree(report).toString());
        reportJson.setType(ReportType.FORUM_MONTHLY_REPORT);
        reportJson.setDate(LocalDateTime.now());


        Report saved = this.reportRepository.save(reportJson);

        return ForumMapper.makeMonthlyReport().toResponse(saved.getId(), report);
    }

}
