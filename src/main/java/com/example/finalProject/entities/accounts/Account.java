package com.example.finalProject.entities.accounts;


import com.example.finalProject.embedables.Money;
import com.example.finalProject.entities.users.AccountHolder;
import com.example.finalProject.enums.Status;

import javax.persistence.*;
import java.time.LocalDate;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public abstract class Account {
        @Id
        @GeneratedValue (strategy = GenerationType.AUTO)
        private Long id;
        @Embedded
        private Money balance;
        @Embedded
        @AttributeOverrides({
                @AttributeOverride(name = "currency", column = @Column(name = "penaltyCurrency")),
                @AttributeOverride(name = "amount", column = @Column(name = "penaltyAmount"))})
        private Money penaltyFee;

        @ManyToOne
        private AccountHolder primaryOwner;
        @ManyToOne
        private AccountHolder secondaryOwner;
        private LocalDate creationDate;
        private Status status;

        public Account(Money balance, Money penaltyFee, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
                this.balance = balance;
                this.penaltyFee = penaltyFee;
                this.primaryOwner = primaryOwner;
                this.secondaryOwner = secondaryOwner;
                this.creationDate = LocalDate.now();
                this.status = Status.ACTIVE;

        }


        public Account() {
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Money getBalance() {
                return balance;
        }

        public void setBalance(Money balance) {
                this.balance = balance;
        }
        public Money getPenaltyFee() {
                return penaltyFee;
        }

        public void setPenaltyFee(Money penaltyFee) {
                this.penaltyFee = penaltyFee;
        }

        public AccountHolder getPrimeryOwner() {
                return primaryOwner;
        }

        public void setPrimeryOwner(AccountHolder primaryOwner) {
                this.primaryOwner = primaryOwner;
        }

        public AccountHolder getSecondaryOwner() {
                return secondaryOwner;
        }

        public void setSecondaryOwner(AccountHolder secondaryOwner) {
                this.secondaryOwner = secondaryOwner;
        }

        public LocalDate getCreationDate() {
                return creationDate;
        }

        public void setCreationDate(LocalDate creationDate) {
                this.creationDate = creationDate;
        }

        public Status getStatus() {
                return status;
        }

        public void setStatus(Status status) {
                this.status = status;
        }

}


