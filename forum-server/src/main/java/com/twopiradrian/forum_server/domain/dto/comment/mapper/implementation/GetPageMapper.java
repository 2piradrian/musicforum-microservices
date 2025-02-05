package com.twopiradrian.forum_server.domain.dto.comment.mapper.implementation;

import com.twopiradrian.entity.Comment;
import com.twopiradrian.entity.PageContent;
import com.twopiradrian.forum_server.domain.dto.comment.request.GetCommentPageReq;
import com.twopiradrian.forum_server.domain.dto.comment.response.GetCommentPageRes;

public class GetPageMapper {

    public GetCommentPageReq toRequest(String forumId, Integer size, Integer page) {
        return GetCommentPageReq.create(
                forumId,
                size,
                page
        );
    }

    public GetCommentPageRes toResponse(PageContent<Comment> comments) {
        return new GetCommentPageRes(
                comments.getContent(),
                comments.getNextPage()
        );
    }

}
