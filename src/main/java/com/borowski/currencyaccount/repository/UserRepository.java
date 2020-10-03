package com.borowski.currencyaccount.repository;

import com.borowski.currencyaccount.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserAccount, Long> {

    boolean existsAccountByPesel(String pesel);

    Optional<UserAccount> findAccountByPesel(String pesel);

}
