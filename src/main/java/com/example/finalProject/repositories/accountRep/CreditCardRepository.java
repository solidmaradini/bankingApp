package com.example.finalProject.repositories.accountRep;


import com.example.finalProject.entities.accounts.Account;
import com.example.finalProject.entities.accounts.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
