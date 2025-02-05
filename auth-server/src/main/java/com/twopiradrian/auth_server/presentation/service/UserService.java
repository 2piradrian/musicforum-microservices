package com.twopiradrian.auth_server.presentation.service;

import com.twopiradrian.auth_server.domain.dto.user.request.*;
import com.twopiradrian.auth_server.domain.dto.user.response.LoginUserRes;
import com.twopiradrian.auth_server.domain.dto.user.response.GetUserByIdRes;
import com.twopiradrian.auth_server.domain.dto.user.response.RegisterUserRes;
import com.twopiradrian.auth_server.domain.dto.user.response.AuthUserRes;

public interface UserService {

    GetUserByIdRes getById(GetUserByIdReq dto);

    RegisterUserRes register(RegisterUserReq dto);

    LoginUserRes login(LoginUserReq dto);

    AuthUserRes auth(AuthUserReq dto);

    void delete(DeleteUserReq dto);

}
