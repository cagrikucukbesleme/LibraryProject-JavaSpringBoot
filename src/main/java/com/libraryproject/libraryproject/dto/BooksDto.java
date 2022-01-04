package com.libraryproject.libraryproject.dto;

import com.libraryproject.libraryproject.entity.Authors;
import com.libraryproject.libraryproject.entity.UserAccount;
import lombok.Data;

import java.io.Serializable;


@Data
public class BooksDto implements Serializable {

    private Long id;

    private String bookName;

    private Boolean isBookActive;


    private UserAccount userAccounts;


    private Authors authors;
}
