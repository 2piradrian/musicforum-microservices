package com.twopiradrian.forum_server.domain.dto.forum.mapper.implementation;

import com.twopiradrian.entity.Forum;
import com.twopiradrian.entity.PageContent;
import com.twopiradrian.forum_server.domain.dto.forum.request.GetForumPageReq;
import com.twopiradrian.forum_server.domain.dto.forum.response.GetForumPageRes;

public class GetPageMapper {

    public GetForumPageReq toRequest(String category, Integer size, Integer page) {
        return GetForumPageReq.create(
                category,
                page,
                size
        );
    }

    public GetForumPageRes toResponse(PageContent<Forum> forums) {
        return new GetForumPageRes(
                forums.getContent(),
                forums.getNextPage()
        );
    }

}
