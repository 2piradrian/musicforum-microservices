package com.twopiradrian.report_server.domain.reports.forum;

import com.twopiradrian.entity.Category;
import com.twopiradrian.report_server.domain.reports.Report;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonthlyForums {

    private Integer month;

    private Integer year;

    private Integer totalForums;

    private Map<Category, Integer> forumsByCategory;

    private Map<Category, Integer> viewsByCategory;

}
