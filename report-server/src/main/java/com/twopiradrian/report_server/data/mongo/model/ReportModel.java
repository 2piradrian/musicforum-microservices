package com.twopiradrian.report_server.data.mongo.model;

import com.twopiradrian.report_server.domain.reports.ReportType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class ReportModel {

    @Id
    private String id;

    private ReportType type;

    private String content;

    private LocalDateTime date;

}
