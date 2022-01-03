package com.libraryproject.libraryproject.service;

import com.libraryproject.libraryproject.dto.UserDto;
import com.libraryproject.libraryproject.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    UserDto save(UserDto userDto);
    void delete(long id);
    List<UserDto>  getAll();
    Page<UserDto> getAll(Pageable pageable);


}
