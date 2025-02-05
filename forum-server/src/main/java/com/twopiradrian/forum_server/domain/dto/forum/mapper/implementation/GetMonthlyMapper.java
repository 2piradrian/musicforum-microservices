package com.twopiradrian.forum_server.domain.dto.forum.mapper.implementation;

import com.twopiradrian.entity.Forum;
import com.twopiradrian.forum_server.domain.dto.forum.request.GetMonthlyForumsReq;
import com.twopiradrian.forum_server.domain.dto.forum.response.GetMonthlyForumsRes;

import java.util.List;

public class GetMonthlyMapper {

    public GetMonthlyForumsReq toRequest(String token, Integer month, Integer year) {
        return GetMonthlyForumsReq.create(
                token,
                month,
                year
        );
    }

    public GetMonthlyForumsRes toResponse(List<Forum> forums) {
        return new GetMonthlyForumsRes(
                forums
        );
    }

}
