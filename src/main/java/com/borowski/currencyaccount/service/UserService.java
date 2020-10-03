package com.borowski.currencyaccount.service;

import com.borowski.currencyaccount.domain.UserAccount;
import com.borowski.currencyaccount.dto.CreateUserAccountDto;
import com.borowski.currencyaccount.exception.AccountWithPeselExists;
import com.borowski.currencyaccount.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserAccount createUser(CreateUserAccountDto dto) {
        assertAccountWithGivenPeselDoesNotExist(dto.getPesel());

        UserAccount user = UserAccount.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .pesel(dto.getPesel())
                .build();

        userRepository.save(user);
        return user;
    }

    private void assertAccountWithGivenPeselDoesNotExist(String pesel) {
        boolean exist = userRepository.existsAccountByPesel(pesel);
        if (exist) {
            throw new AccountWithPeselExists("Account with given pesel already exists!");
        }

    }

    public List<UserAccount> getListOfUserAccounts() {
        List<UserAccount> all = userRepository.findAll();
        return all;
    }

    public Optional<UserAccount> findAccountByPesel(String pesel) {
        Optional<UserAccount> accountByPesel = userRepository.findAccountByPesel(pesel);
        return accountByPesel;

    }


}
