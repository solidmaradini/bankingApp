package com.example.finalProject.services.interfaces;

import com.example.finalProject.entities.users.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountServiceInterface  {


    public AccountHolder createAccountHolder();
}
