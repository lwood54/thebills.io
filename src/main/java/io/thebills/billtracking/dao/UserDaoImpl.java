package io.thebills.billtracking.dao;

import io.thebills.billtracking.entities.UserEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;


@Repository // identifies component as one that can perform CRUD operations
public class UserDaoImpl implements UserDao { // implements the data access object which may contain methods for crud operations
    // used to
    private final EntityManager entityManager;

    public UserDaoImpl(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void createUser(UserEntity newUser) {
        Session session = entityManager.unwrap(Session.class);
        session.save(newUser);
    }
}
