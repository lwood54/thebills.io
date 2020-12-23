package io.thebills.billtracking.services.impl;

import io.thebills.billtracking.beans.User;
import io.thebills.billtracking.dao.UserDao;
import io.thebills.billtracking.entities.UserEntity;
import io.thebills.billtracking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserDao userDao;

    public UserServiceImpl(final UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public UserEntity getUserDetails(final String email) {
        System.out.println("getting user details by email (in UserServiceImpl: " + email);
        UserEntity userEntity = userDao.findUser(email);
        System.out.println("user: " + userEntity);
        return userEntity;
    }

    @Override
    @Transactional
    public void createUser(final User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(user.getEmail());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());

        userDao.createUser(userEntity);
    }

    @Override
    @Transactional
    public List<UserEntity> findAll() {
        List<UserEntity> userList = userDao.findAll();
// https://www.objectdb.com/java/jpa/persistence/retrieve#Retrieval_by_Class_and_Primary_Key
            System.out.println("finding all");
            return userList;
    }
}
