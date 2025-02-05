package com.twopiradrian.forum_server.domain.dto.forum.request;

import com.twopiradrian.entity.Vote;
import com.twopiradrian.error.ErrorHandler;
import com.twopiradrian.error.ErrorType;
import lombok.Getter;

@Getter
public class ToggleForumVotesReq {

    private final String token;

    private final Vote voteType;

    private final String forumId;

    private ToggleForumVotesReq(String token, Vote voteType, String forumId) {
        this.token = token;
        this.voteType = voteType;
        this.forumId = forumId;
    }

    public static ToggleForumVotesReq create(String token, String voteType, String forumId) {

        if (token == null) {
            throw new ErrorHandler(ErrorType.UNAUTHORIZED);
        }

        if (voteType == null || forumId == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        Vote voteEnum = null;
        boolean isValidVote = false;
        for (Vote c : Vote.values()) {
            if (c.name().equals(voteType)) {
                isValidVote = true;
                voteEnum = c;
                break;
            }
        }
        if (!isValidVote) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        return new ToggleForumVotesReq(token, voteEnum, forumId);
    }

}
