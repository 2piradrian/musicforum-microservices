package com.twopiradrian.forum_server.domain.repository;


import com.twopiradrian.entity.Comment;
import com.twopiradrian.entity.PageContent;

public interface CommentRepository {

    Comment getById(String commentId);

    PageContent getByForumId(String forumId, Integer page, Integer size);

    Comment save(Comment comment);

    Comment update(Comment comment);

}
