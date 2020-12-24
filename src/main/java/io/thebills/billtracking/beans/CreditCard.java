package io.thebills.billtracking.beans;

public class CreditCard {

    private String ccName;
    private String ccDescription;
    private int ccApr;
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
