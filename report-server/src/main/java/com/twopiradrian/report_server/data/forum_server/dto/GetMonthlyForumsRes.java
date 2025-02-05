package com.twopiradrian.report_server.data.forum_server.dto;

import com.twopiradrian.entity.Forum;
import lombok.Getter;

import java.util.List;

@Getter
public class GetMonthlyForumsRes {
    List<Forum> forums;
}
