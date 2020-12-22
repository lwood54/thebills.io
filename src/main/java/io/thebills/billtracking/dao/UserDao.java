package io.thebills.billtracking.dao;

import io.thebills.billtracking.entities.UserEntity;


public interface UserDao {
    void createUser(UserEntity newUser);
}
