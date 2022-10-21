package com.example.finalProject.controllers;


import com.example.finalProject.controllers.interfaces.AccountHolderInterface;
import com.example.finalProject.entities.DTO.TransferDTO;
import com.example.finalProject.entities.DTO.TrasnferResponseDTO;
import com.example.finalProject.entities.accounts.Account;
import com.example.finalProject.entities.users.AccountHolder;
import com.example.finalProject.enums.Status;
import com.example.finalProject.services.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountHolderController implements AccountHolderInterface {

    @Autowired
    AccountHolderService accountHolderService;
    @GetMapping("/accountholder/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder getAccountHolders(@PathVariable Long id){
        return accountHolderService.getAccountHolder(id);
    }

    @PostMapping("/accountholder")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder createAccountHolders(@RequestBody AccountHolder accountHolder){
        return accountHolderService.createAccountHolder(accountHolder);

    }

    @PatchMapping("/transfer")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public TrasnferResponseDTO transferBetweenAccounts(@RequestBody TransferDTO transferDTO){
        return accountHolderService.transferToOneAccountToOther(transferDTO);
    }
    @PutMapping("/change-status")
    public Account changeStatus(@RequestParam Status status, @RequestParam Long id){
        return accountHolderService.changeAccountStatus(status, id);
    }
    @DeleteMapping("/delete-account")
    public void deleteAccount(@PathVariable Long id){
        accountHolderService.deleteAccount(id);
    }

}
