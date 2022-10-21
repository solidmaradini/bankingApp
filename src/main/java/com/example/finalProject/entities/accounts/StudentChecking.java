package com.example.finalProject.entities.accounts;

import com.example.finalProject.embedables.Money;
import com.example.finalProject.entities.users.AccountHolder;
import com.example.finalProject.enums.Status;

import javax.persistence.Entity;
import java.time.LocalDate;


@Entity
public class StudentChecking extends Account{


    public StudentChecking(Money balance, Money penaltyFee, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
        super(balance, penaltyFee, primaryOwner, secondaryOwner);
    }

    public StudentChecking() {
    }
}
