package com.twopiradrian.forum_server.domain.dto.comment.mapper;


import com.twopiradrian.forum_server.domain.dto.comment.mapper.implementation.*;

public class CommentMapper {

    public static GetPageMapper getPage() {
        return new GetPageMapper();
    }

    public static CreateMapper create() {
        return new CreateMapper();
    }

    public static DeleteMapper delete() {
        return new DeleteMapper();
    }

    public static EditMapper edit() {
        return new EditMapper();
    }

    public static ToggleVotesMapper toggleVotes() {
        return new ToggleVotesMapper();
    }

}
