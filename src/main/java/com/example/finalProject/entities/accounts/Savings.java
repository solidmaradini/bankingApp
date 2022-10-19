package com.example.finalProject.entities.accounts;

import com.example.finalProject.embedables.Money;
import com.example.finalProject.entities.users.AccountHolder;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
public class Savings extends Account{

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "minBalanceCurrency")),
            @AttributeOverride(name = "amount", column = @Column(name = "minBalanceAmount"))})

    private Money minimumBalance;
    private BigDecimal interestedRate;

    public Savings(Money balance, Money penaltyFee, AccountHolder primaryOwner, AccountHolder secondaryOwner, BigDecimal interestedRate, Money minimumBalance) {
        super(balance, penaltyFee, primaryOwner, secondaryOwner);
        this.interestedRate = interestedRate;
        this.minimumBalance = minimumBalance;
    }

    public Savings() {
    }

    public Money getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Money minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public BigDecimal getInterestedRate() {
        return interestedRate;
    }

    public void setInterestedRate(BigDecimal interestedRate) {
        this.interestedRate = interestedRate;
    }
}
