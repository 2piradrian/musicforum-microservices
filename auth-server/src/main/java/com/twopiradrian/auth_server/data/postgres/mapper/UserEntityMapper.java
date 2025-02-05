package com.twopiradrian.auth_server.data.postgres.mapper;

import com.twopiradrian.auth_server.data.postgres.model.UserModel;
import com.twopiradrian.entity.User;

public class UserEntityMapper {

    public static User toDomain(UserModel userModel) {
        return new User(
                userModel.getId(),
                userModel.getUsername(),
                userModel.getPassword(),
                userModel.getEmail(),
                userModel.getMemberSince(),
                userModel.getLastLogin(),
                userModel.getRoles(),
                userModel.getStatus()
        );
    }

    public static UserModel toModel(User user) {
        return new UserModel(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getMemberSince(),
                user.getLastLogin(),
                user.getRoles(),
                user.getStatus()
        );
    }

}
