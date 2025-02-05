package com.twopiradrian.forum_server.domain.dto.forum.request;

import com.twopiradrian.entity.Category;
import com.twopiradrian.error.ErrorHandler;
import com.twopiradrian.error.ErrorType;
import lombok.Getter;

@Getter
public class GetForumPageReq {

    private final Category category;

    private final Integer page;

    private final Integer size;

    private GetForumPageReq(Category category, Integer page, Integer size) {
        this.category = category;
        this.page = page;
        this.size = size;
    }

    public static GetForumPageReq create(String category, Integer page, Integer size) {

        Category categoryEnum = null;
        if (category != null ) {
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
        }

        if (page == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        if (page < 0) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        if (size == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        if (size < 0) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        return new GetForumPageReq(categoryEnum, page, size);
    }

}
