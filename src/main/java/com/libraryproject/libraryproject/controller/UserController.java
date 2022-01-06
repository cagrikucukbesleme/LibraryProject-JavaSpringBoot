package com.libraryproject.libraryproject.controller;

import com.libraryproject.libraryproject.dto.AccountDto;
import com.libraryproject.libraryproject.dto.UserDto;

import com.libraryproject.libraryproject.entity.User;
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


    @GetMapping("/getById/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getDataById(id));
    }
    @PutMapping("/updateUser")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto){

        UserDto userDto1=userService.getDataById(userDto.getId());

        return ResponseEntity.ok(userService.updateData(userDto1));
    }

    @DeleteMapping("/deleteById/{id}")
    public void  delete(@PathVariable Long id){
        userService.delete(id);
        System.out.println("ID: " +id+" deleted");
    }

}

