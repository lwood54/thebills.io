package io.thebills.billtracking.services;

import io.thebills.billtracking.beans.User;
import io.thebills.billtracking.entities.UserEntity;

import java.util.List;

public interface UserService {

    // the interface is defining what functions, parameters, and return types are expected when
    // this interface is in use.
    // QUESTION: is this similar saying, here is a contract that is agreed upon when using UserService?

    // creates new user with the provided user data
    void createUser(User user);

    // todo: get user info by passing email, which is primary id
    UserEntity getUserDetails(String email);

    // todo: get list of all users
    List<UserEntity> findAll();

    void updateUser(String email, User updatedUser);

}
