package com.twopiradrian.forum_server.data.postgres.mapper;

import com.twopiradrian.entity.Forum;
import com.twopiradrian.forum_server.data.postgres.model.ForumModel;

public class ForumEntityMapper {

    public static Forum toDomain(ForumModel forumModel) {
        return new Forum(
                forumModel.getId(),
                forumModel.getTitle(),
                forumModel.getContent(),
                forumModel.getViews(),
                forumModel.getAuthorId(),
                forumModel.getUpvoters(),
                forumModel.getDownvoters(),
                forumModel.getCategory(),
                forumModel.getCreatedAt(),
                forumModel.getUpdatedAt(),
                forumModel.getStatus()
        );
    }

    public static ForumModel toModel(Forum forum) {
        return new ForumModel(
                forum.getId(),
                forum.getTitle(),
                forum.getContent(),
                forum.getViews(),
                forum.getAuthorId(),
                forum.getUpvoters(),
                forum.getDownvoters(),
                forum.getCategory(),
                forum.getCreatedAt(),
                forum.getUpdatedAt(),
                forum.getStatus()
        );
    }

}
