package com.borowski.currencyaccount.controller;

import com.borowski.currencyaccount.domain.UserAccount;
import com.borowski.currencyaccount.dto.CreateUserAccountDto;
import com.borowski.currencyaccount.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/account")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserAccount> createUser(@RequestBody @Validated CreateUserAccountDto createUserDto) {
        UserAccount user = userService.createUser(createUserDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<UserAccount>> getAllUsers() {
        List<UserAccount> listOfUsers = userService.getListOfUserAccounts();
        return new ResponseEntity<>(listOfUsers, HttpStatus.OK);
    }

    @GetMapping("/{pesel}")
    public ResponseEntity<Optional<UserAccount>> findUserByPesel(@PathVariable String pesel) {
        Optional<UserAccount> byPesel = userService.findAccountByPesel(pesel);
        return ResponseEntity.ok(byPesel);
    }


}
