package com.example.finalProject.services;

import com.example.finalProject.embedables.Money;
import com.example.finalProject.entities.DTO.AccountDTO;
import com.example.finalProject.entities.accounts.*;
import com.example.finalProject.entities.users.AccountHolder;
import com.example.finalProject.repositories.accountRep.CheckingRepository;
import com.example.finalProject.repositories.accountRep.CreditCardRepository;
import com.example.finalProject.repositories.accountRep.SavingRepository;
import com.example.finalProject.repositories.accountRep.StudentCheckingRepository;
import com.example.finalProject.repositories.usersRep.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

@Service
public class AccountsService {

    @Autowired
    CheckingRepository checkingRepository;

    @Autowired
    StudentCheckingRepository studentCheckingRepository;

    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    SavingRepository savingRepository;
    @Autowired
    CreditCardRepository creditCardRepository;

    public Account createChecking(AccountDTO checkingDTO){

        Money balance = new Money(new BigDecimal(checkingDTO.getBalance()));
        Money penaltyFee = new Money(new BigDecimal(checkingDTO.getPenaltyFee()));
        AccountHolder primaryOwner = accountHolderRepository.findById(checkingDTO.getPrimaryOwnerId()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NO_CONTENT));

        AccountHolder secondaryOwner = null;
        if(checkingDTO.getSecondaryOwnerId() != null && accountHolderRepository.findById(checkingDTO.getSecondaryOwnerId()).isPresent()){
            secondaryOwner = accountHolderRepository.findById(checkingDTO.getSecondaryOwnerId()).get();
        }
//        AccountHolder secondaryOwner = accountHolderRepository.findById(checkingDTO.getSecondaryOwnerId()).orElseThrow(()->
//                new ResponseStatusException(HttpStatus.NO_CONTENT));
        Money minimumBalance = null;
        if(checkingDTO.getMinimumBalance() == null){
            minimumBalance = new Money(new BigDecimal(250));
        }else{
            minimumBalance = new Money(new BigDecimal(checkingDTO.getMinimumBalance()));
        }

        if(Period.between(primaryOwner.getDateOfbirth(), LocalDate.now()).getYears() < 24){
           return studentCheckingRepository.save(new StudentChecking(balance,penaltyFee, primaryOwner, secondaryOwner));

        }
        Checking checking = new Checking(balance, penaltyFee, primaryOwner, secondaryOwner);

        return checkingRepository.save(checking);
    }

    public Savings createSavings(AccountDTO savingsDTO){

        Money balance = new Money(new BigDecimal(savingsDTO.getBalance()));
        Money penaltyFee = new Money(new BigDecimal(savingsDTO.getPenaltyFee()));
        AccountHolder primaryOwner = accountHolderRepository.findById(savingsDTO.getPrimaryOwnerId()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NO_CONTENT));
        AccountHolder secondaryOwner = accountHolderRepository.findById(savingsDTO.getSecondaryOwnerId()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NO_CONTENT));
        BigDecimal interestRate =  new BigDecimal(savingsDTO.getInterestedRate());

        Money minimumBalance = null;
        if(savingsDTO.getMinimumBalance() == null){
            minimumBalance = new Money(new BigDecimal(5000));
        }else{
            minimumBalance = new Money(new BigDecimal(savingsDTO.getMinimumBalance()));
        }


        Savings savings = new Savings(balance, penaltyFee, primaryOwner, secondaryOwner, minimumBalance, interestRate);

        return  savingRepository.save(savings);
    }
    public CreditCard newCreditCard(AccountDTO creditCardDTO){

        Money balance = new Money(new BigDecimal(creditCardDTO.getBalance()));
        Money penaltyFee = new Money(new BigDecimal(creditCardDTO.getPenaltyFee()));
        AccountHolder primaryOwner = accountHolderRepository.findById(creditCardDTO.getPrimaryOwnerId()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NO_CONTENT));
        AccountHolder secondaryOwner = accountHolderRepository.findById(creditCardDTO.getSecondaryOwnerId()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NO_CONTENT));
        BigDecimal interestedRate =  new BigDecimal(creditCardDTO.getInterestedRate());
        Money minimumBalance = null;
        if(creditCardDTO.getMinimumBalance() == null){
            minimumBalance = new Money(new BigDecimal(5000));
        }else{
            minimumBalance = new Money(new BigDecimal(creditCardDTO.getMinimumBalance()));
        }

//        Money creditLimit = new Money(new BigDecimal(creditCardDTO.));
        CreditCard creditCard = new CreditCard(balance, penaltyFee, primaryOwner, secondaryOwner, minimumBalance, interestedRate);
        return  creditCardRepository.save(creditCard);

    }
}
