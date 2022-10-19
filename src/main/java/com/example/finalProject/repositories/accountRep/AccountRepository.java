package com.example.finalProject.repositories.accountRep;

import com.example.finalProject.entities.accounts.Account;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AccountRepository extends JpaRepository<Account, Long> {


}
