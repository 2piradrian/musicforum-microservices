package com.twopiradrian.auth_server.data.repository;

import com.twopiradrian.auth_server.data.postgres.mapper.UserEntityMapper;
import com.twopiradrian.auth_server.data.postgres.model.UserModel;
import com.twopiradrian.auth_server.data.postgres.repository.PostgresUserRepository;
import com.twopiradrian.auth_server.domain.repository.UserRepository;
import com.twopiradrian.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserRepositoryI implements UserRepository {

    private final PostgresUserRepository userRepository;

    @Override
    public User getById(String userId) {
        UserModel userModel = this.userRepository.findById(userId).orElse(null);
        return userModel != null ? UserEntityMapper.toDomain(userModel) : null;
    }

    @Override
    public User getByEmail(String email) {
        UserModel userModel = this.userRepository.findByEmail(email).orElse(null);
        return userModel != null ? UserEntityMapper.toDomain(userModel) : null;
    }

    @Override
    public User getByUsername(String username) {
        UserModel userModel = this.userRepository.findByUsername(username).orElse(null);
        return userModel != null ? UserEntityMapper.toDomain(userModel) : null;
    }

    @Override
    public User save(User user) {
        UserModel userModel = UserEntityMapper.toModel(user);
        UserModel saved = this.userRepository.save(userModel);

        return UserEntityMapper.toDomain(saved);
    }

    @Override
    public User update(User user) {
        UserModel userModel = UserEntityMapper.toModel(user);
        UserModel updated = this.userRepository.save(userModel);

        return UserEntityMapper.toDomain(updated);
    }

}
