package com.example.finalProject.controllers;

import com.example.finalProject.entities.DTO.AccountDTO;
import com.example.finalProject.entities.accounts.Checking;
import com.example.finalProject.entities.accounts.Savings;
import com.example.finalProject.services.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountsService accountsService;

    @PostMapping("/new-checking")
    @ResponseStatus(HttpStatus.CREATED)
    public Checking createNewChecking(@RequestBody AccountDTO checkingDTO){
        return  accountsService.createChecking(checkingDTO);

    }

    @PostMapping("/new-savings")
    public Savings createNewSavings(@RequestBody AccountDTO savingsDTO){
        return accountsService.createSavings(savingsDTO);

    }
}
