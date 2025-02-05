package com.twopiradrian.auth_server.domain.dto.user.response;

import com.twopiradrian.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public class AuthUserRes {

    private final String id;

    private final String email;

    private final Set<Role> roles;

}
