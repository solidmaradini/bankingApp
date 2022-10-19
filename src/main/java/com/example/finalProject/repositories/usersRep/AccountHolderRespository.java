package com.example.finalProject.repositories.usersRep;


import com.example.finalProject.entities.users.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHolderRespository  extends JpaRepository<AccountHolder, Long> {
}
