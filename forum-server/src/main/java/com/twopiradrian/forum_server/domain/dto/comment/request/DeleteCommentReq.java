package com.twopiradrian.forum_server.domain.dto.comment.request;

import com.twopiradrian.error.ErrorHandler;
import com.twopiradrian.error.ErrorType;
import lombok.Getter;

@Getter
public class DeleteCommentReq {

    private final String token;

    private final String commentId;

    private DeleteCommentReq(String token, String commentId) {
        this.token = token;
        this.commentId = commentId;
    }

    public static DeleteCommentReq create(String token, String commentId) {

        if (token == null) {
            throw new ErrorHandler(ErrorType.UNAUTHORIZED);
        }

        if (commentId == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        return new DeleteCommentReq(token, commentId);
    }

}
