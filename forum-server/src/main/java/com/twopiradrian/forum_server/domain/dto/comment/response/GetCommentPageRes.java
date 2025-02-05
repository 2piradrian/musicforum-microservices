package com.twopiradrian.forum_server.domain.dto.comment.response;

import com.twopiradrian.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GetCommentPageRes {

    List<Comment> comments;

    Integer nextPage;

}
