package com.example.finalProject.services.interfaces;

import com.example.finalProject.entities.users.AccountHolder;
import com.example.finalProject.entities.users.Admin;
import com.example.finalProject.entities.users.ThirdParty;

public interface UserServiceInterface {
    Admin createAdmin(Admin admin);

    AccountHolder createAccountHolder(AccountHolder accountHolder);

    ThirdParty createThirdParty(ThirdParty thirdParty);
}
