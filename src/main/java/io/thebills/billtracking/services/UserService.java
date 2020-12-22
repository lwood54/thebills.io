package io.thebills.billtracking.services;

import io.thebills.billtracking.beans.User;

public interface UserService {

    // the interface is defining what functions, parameters, and return types are expected when
    // this interface is in use.
    // QUESTION: is this similar saying, here is a contract that is agreed upon when using UserService?
    User getUserDetails(String email);
    void createUser(User user);
}
