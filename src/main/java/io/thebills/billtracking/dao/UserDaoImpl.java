package io.thebills.billtracking.dao;

import io.thebills.billtracking.entities.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
    @Autowired // QUESTION: is Autowired essential here, it did not seem to do anything.    A: Not necessarily when structure is setup correctly
    private final EntityManager entityManager;

    // if UserDaoImpl is never called, when is entityManager passed as argument? Is this automatic at runtime?
    public UserDaoImpl(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void createUser(UserEntity newUser) {
    //        Session currentSession = entityManager.unwrap(Session.class);
    //        currentSession.save(newUser);
        entityManager.unwrap(Session.class).save(newUser);
    }

    @Override
    @Transactional
    public UserEntity findUser(String email) {
        // I know session creates a connection with the db, not sure what Session.class is
        // NOTE: Types in use here:     Session currentSession = entityManager.unwrap(Session.class);
        //                              UserEntity userEntity = currentSession.find(UserEntity.class, email);
        return entityManager.unwrap(Session.class).find(UserEntity.class, email);
    }

    @Override
    @Transactional
    public List<UserEntity> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        // NOTE: Location of issue when error was User is not mapped was the search string below this line User --> UserEntity
        // NOTE: Types in use here: Query<UserEntity> query = currentSession.createQuery("from UserEntity", UserEntity.class);
        //                          List<UserEntity> list = query.getResultList();
        return currentSession.createQuery("from UserEntity", UserEntity.class).getResultList();
    }

    @Override
    @Transactional
    public UserEntity updateUser(String email, UserEntity updatedUser) {
        entityManager.unwrap(Session.class).update(updatedUser);
        // todo: only return updatedUser if successful update
        return updatedUser;
    }

    @Override
    public void deleteUser(String email) {
        Session currentSession = entityManager.unwrap(Session.class);
        // NOTE: delete would not work without adding the transaction, then committing when done
        Transaction tx = currentSession.beginTransaction();
        UserEntity userToDelete = currentSession.load(UserEntity.class, email);
        System.out.println("Using email..." + email);
        System.out.println("Deleting user..." + userToDelete);
        currentSession.delete(userToDelete);
        tx.commit();
    }
}
