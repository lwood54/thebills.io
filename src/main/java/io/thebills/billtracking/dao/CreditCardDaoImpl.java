package io.thebills.billtracking.dao;

import io.thebills.billtracking.entities.CreditCardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CreditCardDaoImpl implements CreditCardDao{

    @Autowired
    private final EntityManager entityManager;

    public CreditCardDaoImpl(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void createCreditCard(CreditCardEntity newCC) {

    }

    @Override
    public CreditCardEntity findCC(String ccName) {
        return null;
    }

    @Override
    public List<CreditCardEntity> findAll() {
        return null;
    }

    @Override
    public CreditCardEntity updateCC(String ccName, CreditCardEntity updatedCC) {
        return null;
    }

    @Override
    public void deleteCC(String ccName) {

    }
}
