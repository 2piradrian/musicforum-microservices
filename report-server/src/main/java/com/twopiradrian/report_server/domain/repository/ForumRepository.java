package com.twopiradrian.report_server.domain.repository;

import com.twopiradrian.entity.Forum;

import java.util.List;

public interface ForumRepository {

    List<Forum> getMonthlyForums(String token, Integer month, Integer year);

}
