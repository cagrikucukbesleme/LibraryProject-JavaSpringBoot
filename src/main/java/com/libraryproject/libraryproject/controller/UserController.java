package com.libraryproject.libraryproject.controller;

import com.libraryproject.libraryproject.dto.AccountDto;
import com.libraryproject.libraryproject.dto.UserDto;

import com.libraryproject.libraryproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> saveData(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.save(userDto));
    }

//    @PostMapping("/account")
//    public ResponseEntity<AccountDto> saveData(@RequestBody AccountDto accountDto){
//        return ResponseEntity.ok(userService.save(accountDto));
//    }


    @GetMapping
    public ResponseEntity<List<UserDto>> getData(){
        return ResponseEntity.ok(userService.getAll());
    }

}

