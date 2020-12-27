package io.thebills.billtracking.services;

import io.thebills.billtracking.beans.User;
import io.thebills.billtracking.entities.UserEntity;

import java.util.List;

public interface UserService {

    // the interface is defining what functions, parameters, and return types are expected when
    // this interface is in use.

    // creates new user with the provided user data
    void createUser(User user);

    UserEntity getUserDetails(String email);

    List<UserEntity> findAll();

    UserEntity updateUser(String email, User updatedUser);

    void deleteUser(String email);
}
