package com.twopiradrian.forum_server.domain.repository;

import com.twopiradrian.entity.TokenClaims;
import com.twopiradrian.entity.User;

public interface AuthRepository {

    TokenClaims auth(String token);

    User getById(String userId);

}
