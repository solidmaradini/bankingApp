package com.example.finalProject.services;

import com.example.finalProject.embedables.Money;
import com.example.finalProject.entities.DTO.AccountDTO;
import com.example.finalProject.entities.accounts.Checking;
import com.example.finalProject.entities.accounts.Savings;
import com.example.finalProject.entities.users.AccountHolder;
import com.example.finalProject.repositories.accountRep.CheckingRepository;
import com.example.finalProject.repositories.accountRep.SavingRepository;
import com.example.finalProject.repositories.usersRep.AccountHolderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class AccountsService {

    @Autowired
    CheckingRepository checkingRepository;

    @Autowired
    AccountHolderRespository accountHolderRespository;
    @Autowired
    SavingRepository savingRepository;

    public Checking createChecking(AccountDTO checkingDTO){

        Money balance = new Money(new BigDecimal(checkingDTO.getBalance()));
        Money penaltyFee = new Money(new BigDecimal(checkingDTO.getPenaltyFee()));
        AccountHolder primaryOwner = accountHolderRespository.findById(checkingDTO.getPrimaryOwnerId()).get();
        AccountHolder secondaryOwner = accountHolderRespository.findById(checkingDTO.getSecondaryOwnerId()).get();
        Checking checking = new Checking(balance, penaltyFee, primaryOwner, secondaryOwner);

        return checkingRepository.save(checking);
    }

    public Savings createSavings(AccountDTO savingsDTO){

        Money balance = new Money(new BigDecimal(savingsDTO.getBalance()));
        Money penaltyFee = new Money(new BigDecimal(savingsDTO.getPenaltyFee()));
        AccountHolder primaryOwner = accountHolderRespository.findById(savingsDTO.getPrimaryOwnerId()).get();
        AccountHolder secondaryOwner = accountHolderRespository.findById(savingsDTO.getSecondaryOwnerId()).get();
        BigDecimal interestRate =  new BigDecimal(savingsDTO.getInterestedRate());

        Money minimumBalance = null;
        if(savingsDTO.getMinimumBalance() == null){
            minimumBalance = new Money(new BigDecimal(5000));
        }else{
            minimumBalance = new Money(new BigDecimal(savingsDTO.getMinimumBalance()));
        }


        Savings savings = new Savings(balance, penaltyFee, primaryOwner, secondaryOwner, interestRate, minimumBalance);

        return  savingRepository.save(savings);
    }
    //public AccountHolder
}
