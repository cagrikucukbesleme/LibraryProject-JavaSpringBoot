package com.libraryproject.libraryproject.dto;

import com.libraryproject.libraryproject.entity.Books;
import com.libraryproject.libraryproject.entity.User;
import com.libraryproject.libraryproject.entity.UserAccount;
import lombok.Data;


import java.io.Serializable;
import java.util.List;
@Data
public class AccountDto implements Serializable {
    private Long id;


    private UserAccount.BookType bookType;

    private Boolean isUserActive;




}
