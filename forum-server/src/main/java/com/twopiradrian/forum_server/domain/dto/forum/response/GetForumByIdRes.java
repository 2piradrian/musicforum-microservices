package com.twopiradrian.forum_server.domain.dto.forum.response;

import com.twopiradrian.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class GetForumByIdRes {

    private final String authorId;

    private final String authorUsername;

    private final String forumId;

    private final String title;

    private final String content;

    private final Integer views;

    private final Integer upvoters;

    private final Integer downvoters;

    private final Category category;

    private final LocalDateTime createdAt;

}
