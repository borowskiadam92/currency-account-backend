package com.borowski.currencyaccount.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {

    @Id
    @Column(length = 15, nullable = false, unique = true, name = "pesel")
    private String pesel;
    @NonNull
    private String name;
    @NonNull
    private String surname;


}
