package com.twopiradrian.forum_server.domain.repository;

import com.twopiradrian.entity.Category;
import com.twopiradrian.entity.Forum;
import com.twopiradrian.entity.PageContent;

import java.util.List;

public interface ForumRepository {

    Forum getById(String forumId);

    PageContent<Forum> getAllForums(Integer page, Integer size, Category category);

    List<Forum> getMonthlyForums(Integer month, Integer year);

    Forum save(Forum forum);

    Forum update(Forum forum);

}
