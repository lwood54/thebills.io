package io.thebills.billtracking.services.impl;

import io.thebills.billtracking.beans.User;
import io.thebills.billtracking.dao.UserDao;
import io.thebills.billtracking.entities.UserEntity;
import io.thebills.billtracking.services.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AltUserServiceImpl implements UserService{

    private final UserDao userDao;

    public AltUserServiceImpl(final UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserDetails(final String email) {
        System.out.println("ALTERNATE: getting user details by email (in AltUserServiceImpl): " + email);
        User user = new User();
        user.setEmail(email);
        System.out.println("user: " + user);
        return user;
    }

    @Override
    public void createUser(final User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(user.getEmail());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());

        userDao.createUser(userEntity);
    }
}

