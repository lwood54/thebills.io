package io.thebills.billtracking.dao;

import io.thebills.billtracking.entities.CreditCardEntity;
import io.thebills.billtracking.entities.UserEntity;

import java.util.List;

public interface CreditCardDao {
    void createCreditCard(CreditCardEntity newCC);
    CreditCardEntity findCC(String ccName);
    List<CreditCardEntity> findAll();
    CreditCardEntity updateCC(String ccName, CreditCardEntity updatedCC);
    void deleteCC(String ccName);
}
