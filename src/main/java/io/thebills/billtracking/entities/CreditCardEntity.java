package io.thebills.billtracking.entities;

import javax.persistence.*;

@Entity
@Table(name="creditcard")
public class CreditCardEntity {

    @Id
    @Column
    private String ccName;

    @Column
    private String ccDescription;

    @Column
    private int ccApr;

    @Column
    private int ccMinMonthly;

    public String getCcName() {
        return ccName;
    }

    public void setCcName(String ccName) {
        this.ccName = ccName;
    }

    public String getCcDescription() {
        return ccDescription;
    }

    public void setCcDescription(String ccDescription) {
        this.ccDescription = ccDescription;
    }

    public int getCcApr() {
        return ccApr;
    }

    public void setCcApr(int ccApr) {
        this.ccApr = ccApr;
    }

    public int getCcMinMonthly() {
        return ccMinMonthly;
    }

    public void setCcMinMonthly(int ccMinMonthly) {
        this.ccMinMonthly = ccMinMonthly;
    }
}
