package com.example.finalProject.entities.accounts;

import com.example.finalProject.embedables.Money;
import com.example.finalProject.entities.users.AccountHolder;

import javax.persistence.Entity;


@Entity
public class StudentChecking extends Account{


    public StudentChecking(Money balance, Money minimumBalance, Money penaltyFee, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
        super(balance, penaltyFee, primaryOwner, secondaryOwner);
    }

    public StudentChecking() {
    }
}
