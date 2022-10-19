package com.example.finalProject.services;

import com.example.finalProject.controllers.interfaces.AccountHolderInterface;
import com.example.finalProject.embedables.Money;
import com.example.finalProject.entities.DTO.TransferDTO;
import com.example.finalProject.entities.DTO.TrasnferResponseDTO;
import com.example.finalProject.entities.accounts.Account;
import com.example.finalProject.entities.users.AccountHolder;
import com.example.finalProject.repositories.accountRep.AccountRepository;
import com.example.finalProject.repositories.usersRep.AccountHolderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountHolderService implements AccountHolderInterface {

    //metodos para crear accountHolder;
    //metodos para tranferir de una cuenta a la otra;
    //metodo para que un AH vea su balances;
    @Autowired
    AccountHolderRespository accountHolderRespository;

    @Autowired
    AccountRepository accountRepository;


    public AccountHolder createAccountHolder(AccountHolder accountHolder){
        return accountHolderRespository.save(accountHolder);
    }
    public TrasnferResponseDTO transferToOneAccountToOther(TransferDTO transferDTO) {

        if (accountRepository.findById(transferDTO.getReceivingId()).isPresent() && accountRepository.findById(transferDTO.getSendingId()).isPresent()) {

            Account sendingAccount = accountRepository.findById(transferDTO.getSendingId()).get();
            Account receivingAccount = accountRepository.findById(transferDTO.getReceivingId()).get();
            BigDecimal amount = new BigDecimal(transferDTO.getAmount());

            if (sendingAccount.getBalance().getAmount().compareTo(amount) < 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The account doesn't have enough funds");
            }
            sendingAccount.setBalance(new Money(sendingAccount.getBalance().decreaseAmount(amount)));
            receivingAccount.setBalance(new Money(receivingAccount.getBalance().increaseAmount(amount)));
            accountRepository.saveAll(List.of(sendingAccount, receivingAccount));
            return new TrasnferResponseDTO(sendingAccount.getPrimeryOwner().getName(), receivingAccount.getPrimeryOwner().getName(), amount);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "one or both of the accounts do not exist");


    }


}
