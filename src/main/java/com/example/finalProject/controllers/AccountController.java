package com.example.finalProject.controllers;

import com.example.finalProject.controllers.interfaces.AccountInterface;
import com.example.finalProject.entities.DTO.AccountDTO;
import com.example.finalProject.entities.accounts.Account;
import com.example.finalProject.entities.accounts.Checking;
import com.example.finalProject.entities.accounts.CreditCard;
import com.example.finalProject.entities.accounts.Savings;
import com.example.finalProject.services.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController implements AccountInterface {

    @Autowired
    AccountsService accountsService;

    @PostMapping("/new-checking")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createNewChecking(@RequestBody AccountDTO checkingDTO){
        return  accountsService.createChecking(checkingDTO);

    }

    @PostMapping("/new-savings")
    @ResponseStatus(HttpStatus.CREATED)
    public Savings createNewSavings(@RequestBody AccountDTO savingsDTO){
        return accountsService.createSavings(savingsDTO);

    }
    @PostMapping("/new-credit-card")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCard newCreditCard(@RequestBody AccountDTO creditCardDTO){
        return accountsService.newCreditCard(creditCardDTO);

    }



}
