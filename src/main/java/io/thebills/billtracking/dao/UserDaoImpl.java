package io.thebills.billtracking.dao;

import io.thebills.billtracking.entities.UserEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

// UserDaoImpl implements or carries out the UserDao methods and overrides with specifics
// this will not be used directly, instead the interface will be called providing access to these methods

@Repository // identifies component as one that can perform CRUD operations
public class UserDaoImpl implements UserDao { // implements the data access object which may contain methods for crud operations

    // used to help control db operations more simple, useful built in functions
    @Autowired // QUESTION: is Autowired essential here, it did not seem to do anything.
    private final EntityManager entityManager;

    // if UserDaoImpl is never called, when is entityManager passed as argument? Is this automatic at runtime?
    public UserDaoImpl(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void createUser(UserEntity newUser) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(newUser);
    }

    @Override
    @Transactional
    public UserEntity findUser(String email) {
        // I know session creates a connection with the db, not sure what Session.class is
        Session currentSession = entityManager.unwrap(Session.class);
//        User user = currentSession.find(User.class, email);
        UserEntity userEntity = currentSession.find(UserEntity.class, email);
        return userEntity;
    }

    @Override
    public List<UserEntity> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        // NOTE: Location of issue when error was User is not mapped was the search string below this line User --> UserEntity
        Query<UserEntity> query = currentSession.createQuery("from UserEntity", UserEntity.class);
        List<UserEntity> list = query.getResultList();
        return list;
    }
}
