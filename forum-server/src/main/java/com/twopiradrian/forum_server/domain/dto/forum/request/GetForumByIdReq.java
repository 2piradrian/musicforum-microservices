package com.twopiradrian.forum_server.domain.dto.forum.request;

import com.twopiradrian.error.ErrorHandler;
import com.twopiradrian.error.ErrorType;
import lombok.Getter;

@Getter
public class GetForumByIdReq {

    private final String forumId;

    private GetForumByIdReq(String forumId) {
        this.forumId = forumId;
    }

    public static GetForumByIdReq create(String forumId) {

        if (forumId == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        return new GetForumByIdReq(forumId);
    }

}
