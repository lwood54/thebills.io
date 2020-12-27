package io.thebills.billtracking.entities;

import io.thebills.billtracking.beans.CreditCard;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// UserEntity is the shape of our data table, each row being a user

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cc_foreign_key", referencedColumnName = "ccName") // will also create a foreign key with this entity primary id, eg 'email'
    private List<CreditCardEntity> creditCards = new ArrayList<CreditCardEntity>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // QUESTION: Unsure if I need to do getters/setters for list joined to cc table
//    public List<CreditCardEntity> getCreditCards() {
//        return creditCards;
//    }
//
//    public void setCreditCards(List<CreditCardEntity> creditCards) {
//        this.creditCards = creditCards;
//    }
}
