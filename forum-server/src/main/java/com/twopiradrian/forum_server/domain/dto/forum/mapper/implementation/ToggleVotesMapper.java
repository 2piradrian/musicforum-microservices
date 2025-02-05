package com.twopiradrian.forum_server.domain.dto.forum.mapper.implementation;


import com.twopiradrian.forum_server.domain.dto.forum.request.ToggleForumVotesReq;

import java.util.Map;

public class ToggleVotesMapper {

    public ToggleForumVotesReq toRequest(String token, Map<String, Object> payload) {
        return ToggleForumVotesReq.create(
                token,
                (String) payload.get("voteType"),
                (String) payload.get("forumId")
        );
    }

}
