package com.example.finalProject;

import com.example.finalProject.embedables.Address;
import com.example.finalProject.embedables.Money;
import com.example.finalProject.entities.accounts.Checking;
import com.example.finalProject.entities.accounts.CreditCard;
import com.example.finalProject.entities.users.AccountHolder;
import com.example.finalProject.repositories.accountRep.CheckingRepository;
import com.example.finalProject.repositories.accountRep.CreditCardRepository;
import com.example.finalProject.repositories.usersRep.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class FinalProjectApplication implements CommandLineRunner {

	@Autowired
	AccountHolderRepository accountHolderRepository;

	@Autowired
	CheckingRepository checkingRepository;
	@Autowired
	CreditCardRepository creditCardRepository;

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Address address = new Address("calle asd", "478");
		LocalDate dateOfBirth = LocalDate.of(2000, 1, 1);

		AccountHolder accountHolder = new AccountHolder(dateOfBirth, address, "Sole", address);
		AccountHolder accountHolder2 = new AccountHolder(dateOfBirth, address, "Claudia", address);

		accountHolderRepository.saveAll(List.of(accountHolder, accountHolder2));

		Checking checking1 = new Checking(new Money(new BigDecimal("1000")), new Money(new BigDecimal("50")), accountHolder, accountHolder);
		Checking checking2 = new Checking(new Money(new BigDecimal("1000")), new Money(new BigDecimal("50")), accountHolder2, accountHolder2);

		checkingRepository.saveAll(List.of(checking1, checking2));

		CreditCard creditcard = new CreditCard(new Money(new BigDecimal("1000")), new Money(new BigDecimal("50")), accountHolder, accountHolder, new Money(new BigDecimal("250")), new BigDecimal(String.valueOf(0.5)));
		CreditCard creditCard = new CreditCard(new Money(new BigDecimal("1000")), new Money(new BigDecimal("50")), accountHolder2, accountHolder2, new Money(new BigDecimal("250")), new BigDecimal(String.valueOf(0.5)));
		creditCardRepository.saveAll(List.of(creditcard, creditCard));

		System.out.println(accountHolderRepository.save(accountHolder));
	}
}
