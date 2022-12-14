package com.example.finalProject.entities.accounts;

import com.example.finalProject.embedables.Money;
import com.example.finalProject.entities.users.AccountHolder;
import com.example.finalProject.enums.Status;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;


@Entity
public class Savings extends Account{

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "minBalanceCurrency")),
            @AttributeOverride(name = "amount", column = @Column(name = "minBalanceAmount"))})

    private Money minimumBalance = new Money(BigDecimal.valueOf(1000));
    private BigDecimal interestedRate = BigDecimal.valueOf(0.00025);


    public Savings(Money balance, Money penaltyFee, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money minimumBalance, BigDecimal interestedRate) {
        super(balance, penaltyFee, primaryOwner, secondaryOwner);
        this.minimumBalance = minimumBalance;
        this.interestedRate = interestedRate;
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

    public Savings() {
    }

}
