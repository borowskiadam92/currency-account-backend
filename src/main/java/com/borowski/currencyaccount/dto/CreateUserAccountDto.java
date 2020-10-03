package com.borowski.currencyaccount.dto;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class CreateUserAccountDto {

    @NotNull
    private String name;
    @NotNull
    private String surname;
    //@PESEL
    private String pesel;

}
