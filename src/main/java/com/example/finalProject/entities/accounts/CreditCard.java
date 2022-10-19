package com.example.finalProject.entities.accounts;

import com.example.finalProject.embedables.Money;
import com.example.finalProject.entities.users.AccountHolder;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
public class CreditCard extends Account{

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "creditLimitCurrency")),
            @AttributeOverride(name = "amount", column = @Column(name = "creditLimitAmount"))})
    private Money creditLimit;

    private BigDecimal interestRate;

    public CreditCard(Money balance, Money penaltyFee, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money creditLimit, BigDecimal interestRate) {
        super(balance, penaltyFee, primaryOwner, secondaryOwner);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }

    public CreditCard() {
    }

    public Money getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Money creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
}
