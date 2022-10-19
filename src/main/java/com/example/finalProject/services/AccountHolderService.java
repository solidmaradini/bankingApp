package com.example.finalProject.services;

import com.example.finalProject.controllers.interfaces.AccountHolderInterface;
import com.example.finalProject.entities.users.AccountHolder;
import com.example.finalProject.repositories.usersRep.AccountHolderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountHolderService implements AccountHolderInterface {

    //metodos para crear accountHolder;
    //metodos para tranferir de una cuenta a la otra;
    //metodo para que un AH vea su balances;
    @Autowired
    AccountHolderRespository accountHolderRespository;


    public AccountHolder createAccountHolder(AccountHolder accountHolder){
        return accountHolderRespository.save(accountHolder);
    }

}
