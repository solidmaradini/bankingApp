package com.example.finalProject.repositories.usersRep;


import com.example.finalProject.entities.users.ThirdParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ThridPartyRepository extends JpaRepository<ThirdParty, Long> {

}
