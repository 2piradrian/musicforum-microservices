package com.twopiradrian.forum_server.domain.dto.forum.request;

import com.twopiradrian.entity.Category;
import com.twopiradrian.error.ErrorHandler;
import com.twopiradrian.error.ErrorType;
import lombok.Getter;

@Getter
public class EditForumReq {

    private final String token;

    private final String forumId;

    private final String title;

    private final String content;

    private final Category category;

    private EditForumReq(String token, String forumId, String title, String content, Category category) {
        this.token = token;
        this.title = title;
        this.content = content;
        this.category = category;
        this.forumId = forumId;
    }

    public static EditForumReq create(String token, String forumId, String title, String content, String category) {

        if (token == null) {
            throw new ErrorHandler(ErrorType.UNAUTHORIZED);
        }

        if (title == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        title = title.trim();
        if (title.isEmpty() || title.length() > 256) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        if (content == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        content = content.trim();
        if (content.isEmpty() || content.length() > 4096) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        if (category == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        Category categoryEnum = null;
        boolean isValidCategory = false;
        for (Category c : Category.values()) {
            if (c.name().equals(category)) {
                isValidCategory = true;
                categoryEnum = c;
                break;
            }
        }
        if (!isValidCategory) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        return new EditForumReq(token, forumId, title, content, categoryEnum);
    }

}