package com.example.finalProject.repositories.accountRep;


import com.example.finalProject.entities.accounts.Savings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingRepository extends JpaRepository<Savings, Long> {

}
