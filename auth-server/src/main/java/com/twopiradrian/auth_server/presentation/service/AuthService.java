package com.twopiradrian.auth_server.presentation.service;


import com.twopiradrian.entity.Token;
import com.twopiradrian.entity.User;

public interface AuthService {

    String hashPassword(String password);

    Boolean validatePassword(User user, String password);

    String validateToken(String token);

    String getSubject(String token);

    Token createToken(User user);

}
