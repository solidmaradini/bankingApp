package com.example.finalProject;

import com.example.finalProject.embedables.Address;
import com.example.finalProject.entities.users.AccountHolder;
import com.example.finalProject.repositories.usersRep.AccountHolderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class FinalProjectApplication implements CommandLineRunner {

	@Autowired
	AccountHolderRespository accountHolderRespository;

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Address address = new Address("calle asd", "478");
		LocalDate dateOfBirth = LocalDate.of(2000, 1, 1);

		AccountHolder accountHolder = new AccountHolder(dateOfBirth, address, "Sole", address);
		System.out.println(accountHolderRespository.save(accountHolder));
	}
}
