package io.thebills.billtracking.dao;

import io.thebills.billtracking.entities.UserEntity;

import java.util.List;

// UserDao is an interface that establishes the methods that are required to be used
// when implementing this interface

public interface UserDao {
    void createUser(UserEntity newUser);
    UserEntity findUser(String email);
    List<UserEntity> findAll();
    void updateUser(String email, UserEntity updatedUser);
}
