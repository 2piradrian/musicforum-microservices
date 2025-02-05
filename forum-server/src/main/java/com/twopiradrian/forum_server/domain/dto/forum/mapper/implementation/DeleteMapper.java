package com.twopiradrian.forum_server.domain.dto.forum.mapper.implementation;

import com.twopiradrian.forum_server.domain.dto.forum.request.DeleteForumReq;

import java.util.Map;

public class DeleteMapper {

    public DeleteForumReq toRequest(String  token, Map<String, Object> payload) {
        return DeleteForumReq.create(
                token,
                (String) payload.get("forumId")
        );
    }

}
