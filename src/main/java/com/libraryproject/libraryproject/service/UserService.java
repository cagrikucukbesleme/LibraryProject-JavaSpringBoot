package com.libraryproject.libraryproject.service;

import com.libraryproject.libraryproject.dto.AccountDto;
import com.libraryproject.libraryproject.dto.UserDto;
import com.libraryproject.libraryproject.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    UserDto save(UserDto userDto);
    UserDto updateData(UserDto userDto);
//    AccountDto save(AccountDto accountDto);
    void delete(long id);
    List<UserDto>  getAll();
    UserDto  getDataById(long id);
    Page<UserDto> getAll(Pageable pageable);


}
