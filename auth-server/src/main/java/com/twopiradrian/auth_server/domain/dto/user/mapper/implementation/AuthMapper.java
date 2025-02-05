package com.twopiradrian.auth_server.domain.dto.user.mapper.implementation;

import com.twopiradrian.auth_server.domain.dto.user.request.AuthUserReq;
import com.twopiradrian.auth_server.domain.dto.user.response.AuthUserRes;
import com.twopiradrian.entity.User;

public class AuthMapper {

    public AuthUserReq toRequest(String token) {
        return AuthUserReq.create(
                token
        );
    }

    public AuthUserRes toResponse(User user) {
        return new AuthUserRes(
                user.getId(),
                user.getEmail(),
                user.getRoles()
        );
    }

}
