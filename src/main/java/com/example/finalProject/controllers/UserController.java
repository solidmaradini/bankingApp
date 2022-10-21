package com.example.finalProject.controllers;

import com.example.finalProject.entities.accounts.Account;
import com.example.finalProject.entities.users.AccountHolder;
import com.example.finalProject.entities.users.Admin;
import com.example.finalProject.entities.users.ThirdParty;
import com.example.finalProject.entities.users.User;
import com.example.finalProject.repositories.accountRep.AccountRepository;
import com.example.finalProject.repositories.usersRep.UserRepository;
import com.example.finalProject.services.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserController {

        @Autowired
        UserServiceInterface userServiceInterface;

        @Autowired
        UserRepository userRepository;

        @PostMapping("/admin")
        @ResponseStatus(HttpStatus.CREATED)
        public Admin createAdmin(@RequestBody Admin admin){
                System.err.println("!!!!!!!!!" + admin.getName());
            return userServiceInterface.createAdmin(admin);

        }

        @PostMapping("/accountHolder")
        @ResponseStatus(HttpStatus.CREATED)
        public AccountHolder createAccountHolders(@RequestBody AccountHolder accountHolder){
            return userServiceInterface.createAccountHolder(accountHolder);

        }

        @PostMapping("/thirdParty")
        @ResponseStatus(HttpStatus.CREATED)
        public ThirdParty createThirdParty(@RequestBody ThirdParty thirdParty){
            return userServiceInterface.createThirdParty(thirdParty);

        }
        @GetMapping("/users")
        public List<User> findAll(@AuthenticationPrincipal UserDetails userDetails) {
                System.out.println(userDetails.getUsername());

                return userRepository.findAll();
        }
}


