package com.twopiradrian.report_server.domain.reports;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report {

    private String id;

    private ReportType type;

    private String content;

    private LocalDateTime date;

}
