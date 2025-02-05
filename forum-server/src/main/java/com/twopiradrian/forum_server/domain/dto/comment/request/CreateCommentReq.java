package com.twopiradrian.forum_server.domain.dto.comment.request;

import com.twopiradrian.error.ErrorHandler;
import com.twopiradrian.error.ErrorType;
import lombok.Getter;

@Getter
public class CreateCommentReq {

    private final String token;

    private final String forumId;

    private final String content;

    private final String replyTo;

    private CreateCommentReq(String token, String forumId, String content, String replyTo) {
        this.token = token;
        this.forumId = forumId;
        this.content = content;
        this.replyTo = replyTo;
    }

    public static CreateCommentReq create(String token, String forumId, String content, String replyTo) {

        if (token == null) {
            throw new ErrorHandler(ErrorType.UNAUTHORIZED);
        }

        if (forumId == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        if (content == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        content = content.trim();
        if (content.isEmpty() || content.length() > 2048) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        return new CreateCommentReq(token, forumId, content, replyTo);
    }

}
