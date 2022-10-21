package com.example.finalProject.entities.accounts;


import com.example.finalProject.embedables.Money;
import com.example.finalProject.entities.users.AccountHolder;
import com.example.finalProject.enums.Status;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Checking extends Account{
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "minBalanceCurrency")),
            @AttributeOverride(name = "amount", column = @Column(name = "minBalanceAmount"))})
    private final Money minimumBalance = new Money(BigDecimal.valueOf(250));

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "monthlyCurrency")),
            @AttributeOverride(name = "amount", column = @Column(name = "monthlyAmount"))})

    private final Money monthlyMaintenanceFee = new Money(BigDecimal.valueOf(12));


    public Checking(Money balance, Money penaltyFee, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
        super(balance, penaltyFee, primaryOwner, secondaryOwner);

    }
    public Checking() {

    }
    public Money getMinimumBalance() {
        return minimumBalance;
    }

    public Money getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }


}

