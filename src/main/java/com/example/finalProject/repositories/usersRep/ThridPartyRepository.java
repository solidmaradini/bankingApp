package com.example.finalProject.repositories.usersRep;


import com.example.finalProject.entities.users.ThridParty;
import org.aspectj.weaver.bcel.UnwovenClassFileWithThirdPartyManagedBytecode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThridPartyRepository extends JpaRepository<ThridParty, Long> {
}
