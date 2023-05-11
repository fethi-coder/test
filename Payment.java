package fr.sciam;

import java.math.BigDecimal;

public class Payment {
    private boolean isFee;
    private BigDecimal amount;

    public Payment(BigDecimal amount, boolean isFree) {
        this.amount = amount;
        this.isFee = isFree;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal setAmount(BigDecimal amount) {
        this.amount = amount;
        return this.getAmount();
    }

    public boolean setFee(boolean fee) {
        isFee = fee;
        return this.isFee();
    }

    public boolean isFee() {
        return isFee;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "isFee=" + isFee +
                ", amount=" + amount +
                '}';
    }
}
