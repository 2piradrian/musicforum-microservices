package com.twopiradrian.forum_server.data.repository;

import com.twopiradrian.entity.TokenClaims;
import com.twopiradrian.entity.User;
import com.twopiradrian.forum_server.data.auth_server.AuthServerRepository;
import com.twopiradrian.forum_server.domain.repository.AuthRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class AuthRepositoryI implements AuthRepository {

    private final AuthServerRepository authServerRepository;

    @Override
    public TokenClaims auth(String token) {
        Optional<TokenClaims> claims = this.authServerRepository.auth(token);

        return claims.orElse(null);
    }

    @Override
    public User getById(String userId) {
        Optional<User> user = this.authServerRepository.getById(userId);

        return user.orElse(null);
    }



}
