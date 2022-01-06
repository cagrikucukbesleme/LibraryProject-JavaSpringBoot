package com.libraryproject.libraryproject.dto;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data


public class UserDto implements Serializable {

    private Long id;

    private String firstname;

    private String lastname;
    private Boolean isUserActive;
    private List<String> userAccounts;


}
