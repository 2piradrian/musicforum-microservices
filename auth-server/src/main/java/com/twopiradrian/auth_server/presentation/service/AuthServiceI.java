package com.twopiradrian.auth_server.presentation.service;

import com.twopiradrian.auth_server.config.helpers.JWTHelper;
import com.twopiradrian.entity.Token;
import com.twopiradrian.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceI implements AuthService {

    private final PasswordEncoder passwordEncoder;

    private final JWTHelper jwtHelper;

    @Override
    public String hashPassword(String password) {
        return this.passwordEncoder.encode(password);
    }

    @Override
    public Boolean validatePassword(User user, String password) {
        return this.passwordEncoder.matches(password, user.getPassword());
    }

    @Override
    public Token createToken(User user) {
        return new Token(this.jwtHelper.createToken(user));
    }

    @Override
    public String validateToken(String token) {
        if (token == null || token.isEmpty()) {
            return null;
        }

        if (!token.startsWith("Bearer ")) {
            return null;
        }

        String tokenValue = token.replace("Bearer ", "");
        if (this.jwtHelper.validateToken(tokenValue)) {
            return tokenValue;
        }
        
        return null;
    }

    @Override
    public String getSubject(String token) {
        return this.jwtHelper.getSubject(token);
    }

}
