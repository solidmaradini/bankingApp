package com.example.finalProject.repositories.usersRep;


import com.example.finalProject.entities.users.ThridParty;
import com.example.finalProject.entities.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
