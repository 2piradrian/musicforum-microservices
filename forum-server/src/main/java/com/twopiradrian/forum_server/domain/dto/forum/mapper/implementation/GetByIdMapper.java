package com.twopiradrian.forum_server.domain.dto.forum.mapper.implementation;


import com.twopiradrian.entity.Forum;
import com.twopiradrian.entity.User;
import com.twopiradrian.forum_server.domain.dto.forum.request.GetForumByIdReq;
import com.twopiradrian.forum_server.domain.dto.forum.response.GetForumByIdRes;

public class GetByIdMapper {

    public GetForumByIdReq toRequest(String forumId) {
        return GetForumByIdReq.create(
                forumId
        );
    }

    public GetForumByIdRes toResponse(Forum forum, User author) {
        return new GetForumByIdRes(
                author.getId(),
                author.getUsername(),
                forum.getId(),
                forum.getTitle(),
                forum.getContent(),
                forum.getViews(),
                forum.getUpvoters().size(),
                forum.getDownvoters().size(),
                forum.getCategory(),
                forum.getCreatedAt()
        );
    }
}
