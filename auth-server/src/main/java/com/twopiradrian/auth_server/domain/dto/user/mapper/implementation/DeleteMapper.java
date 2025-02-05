package com.twopiradrian.auth_server.domain.dto.user.mapper.implementation;

import com.twopiradrian.auth_server.domain.dto.user.request.DeleteUserReq;

public class DeleteMapper {

    public DeleteUserReq toRequest(String token) {
        return DeleteUserReq.create(
                token
        );
    }

}
