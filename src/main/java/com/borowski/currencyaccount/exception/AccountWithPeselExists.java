package com.borowski.currencyaccount.exception;

public class AccountWithPeselExists extends RuntimeException {
    public AccountWithPeselExists(String message) {
        super(message);
    }

}
