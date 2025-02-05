package com.twopiradrian.auth_server.domain.dto.user.response;

import com.twopiradrian.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@AllArgsConstructor
public class GetUserByIdRes {

    private final String id;

    private final String username;

    private final String email;

    private final Set<Role> roles;

    private final LocalDateTime memberSince;

    private final LocalDateTime lastLogin;

}
