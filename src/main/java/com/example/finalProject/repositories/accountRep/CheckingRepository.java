package com.example.finalProject.repositories.accountRep;


import com.example.finalProject.entities.accounts.Account;
import com.example.finalProject.entities.accounts.Checking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingRepository extends JpaRepository<Checking, Long>{
}
