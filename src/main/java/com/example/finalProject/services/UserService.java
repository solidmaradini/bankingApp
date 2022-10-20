package com.example.finalProject.services;



import com.example.finalProject.entities.users.AccountHolder;
import com.example.finalProject.entities.users.Admin;
import com.example.finalProject.entities.users.ThirdParty;
import com.example.finalProject.repositories.usersRep.AccountHolderRepository;
import com.example.finalProject.repositories.usersRep.AdminRepository;
import com.example.finalProject.repositories.usersRep.ThridPartyRepository;

import com.example.finalProject.services.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserService implements UserServiceInterface {

    @Autowired
    AdminRepository adminRepository;
    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Autowired
    ThridPartyRepository thirdPartyRepository;


    public Admin createAdmin(Admin admin) {
         return adminRepository.save(admin);
    }
    public AccountHolder createAccountHolder(AccountHolder accountHolder){
        return accountHolderRepository.save(accountHolder);

    }
    public ThirdParty createThirdParty(ThirdParty thirdParty){
        return thirdPartyRepository.save(thirdParty);

    }



}