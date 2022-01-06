package com.libraryproject.libraryproject.controller;


import com.libraryproject.libraryproject.dto.BooksDto;

import com.libraryproject.libraryproject.service.BooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {
    private final BooksService booksService;

    @PostMapping
    public ResponseEntity<BooksDto> saveData(@RequestBody BooksDto booksDto){
        return ResponseEntity.ok(booksService.save(booksDto));
    }


    @GetMapping
    public ResponseEntity<List<BooksDto>> getData(){
        return ResponseEntity.ok(booksService.getAll());
    }
    @GetMapping("/getBookById/{id}")
    public ResponseEntity<BooksDto> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(booksService.getBookById(id));
    }
    @PutMapping("/updateBook")
    public ResponseEntity<BooksDto> updateUser(@RequestBody BooksDto booksDto){

        BooksDto booksDto1=booksService.getBookById(booksDto.getId());

        return ResponseEntity.ok(booksService.updateBook(booksDto1));
    }

    @DeleteMapping("/deleteBookById/{id}")
    public void  delete(@PathVariable Long id){
        booksService.delete(id);
        System.out.println("ID: " +id+" deleted");
    }


}
