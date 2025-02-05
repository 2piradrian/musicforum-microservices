package com.twopiradrian.forum_server.domain.dto.comment.mapper.implementation;


import com.twopiradrian.forum_server.domain.dto.comment.request.ToggleCommentVotesReq;

import java.util.Map;

public class ToggleVotesMapper {

    public ToggleCommentVotesReq toRequest(String token, Map<String, Object> payload) {
        return ToggleCommentVotesReq.create(
                token,
                (String) payload.get("voteType"),
                (String) payload.get("commentId")
        );
    }

}
