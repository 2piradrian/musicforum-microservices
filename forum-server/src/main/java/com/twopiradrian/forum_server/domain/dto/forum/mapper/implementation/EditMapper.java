package com.twopiradrian.forum_server.domain.dto.forum.mapper.implementation;

import com.twopiradrian.entity.Forum;
import com.twopiradrian.forum_server.domain.dto.forum.request.EditForumReq;
import com.twopiradrian.forum_server.domain.dto.forum.response.EditForumRes;

import java.util.Map;

public class EditMapper {

    public EditForumReq toRequest(String token, Map<String, Object> payload) {
        return EditForumReq.create(
                token,
                (String) payload.get("forumId"),
                (String) payload.get("title"),
                (String) payload.get("content"),
                (String) payload.get("category")
        );
    }

    public EditForumRes toResponse(Forum forum) {
        return new EditForumRes(
            forum.getId()
        );
    }

}
