package io.thebills.billtracking.services;

import io.thebills.billtracking.beans.User;

public interface UserService {

    User getUserDetails(String email);
    void createUser(User user);
}
