package com.twopiradrian.forum_server.presentation.service;

import com.twopiradrian.forum_server.domain.dto.forum.request.*;
import com.twopiradrian.forum_server.domain.dto.forum.response.*;

public interface ForumService {

    GetForumByIdRes getById(GetForumByIdReq dto);

    GetForumPageRes getForums(GetForumPageReq dto);

    GetMonthlyForumsRes getMonthlyForums(GetMonthlyForumsReq dto);

    CreateForumRes create(CreateForumReq dto);

    EditForumRes edit(EditForumReq dto);

    void toggleVotes(ToggleForumVotesReq dto);

    void delete(DeleteForumReq dto);

}
