package com.twopiradrian.forum_server.domain.dto.comment.mapper.implementation;

import com.twopiradrian.entity.Comment;
import com.twopiradrian.forum_server.domain.dto.comment.request.CreateCommentReq;
import com.twopiradrian.forum_server.domain.dto.comment.response.CreateCommentRes;

import java.util.Map;

public class CreateMapper {

    public CreateCommentReq toRequest(String token, Map<String, Object> payload) {
        return CreateCommentReq.create(
                token,
                (String) payload.get("forumId"),
                (String) payload.get("content"),
                (String) payload.get("replyTo")
        );
    }

    public CreateCommentRes toResponse(Comment comment) {
        return new CreateCommentRes(
                comment.getId()
        );
    }

}
