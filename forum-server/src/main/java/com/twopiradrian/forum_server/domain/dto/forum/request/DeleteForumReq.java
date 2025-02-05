package com.twopiradrian.forum_server.domain.dto.forum.request;

import com.twopiradrian.error.ErrorHandler;
import com.twopiradrian.error.ErrorType;
import lombok.Getter;

@Getter
public class DeleteForumReq {

    private final String token;

    private final String forumId;

    private DeleteForumReq(String token, String forumId) {
        this.token = token;
        this.forumId = forumId;
    }

    public static DeleteForumReq create(String token, String forumId) {

        if (token == null) {
            throw new ErrorHandler(ErrorType.UNAUTHORIZED);
        }

        if (forumId == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        return new DeleteForumReq(token, forumId);
    }

}
