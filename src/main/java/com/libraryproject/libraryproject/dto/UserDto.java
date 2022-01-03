package com.libraryproject.libraryproject.dto;

import com.libraryproject.libraryproject.entity.UserAccount;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private Long id;

    private String firstname;

    private String lastname;
    private List<String> userAccounts;
}
