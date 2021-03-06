package com.libraryproject.libraryproject.service;

import com.libraryproject.libraryproject.dto.BooksDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BooksService {
    BooksDto save(BooksDto booksDto);
    BooksDto updateBook(BooksDto booksDto);
    void delete(long id);
    List<BooksDto> getAll();
    BooksDto getBookById(long id);
    Page<BooksDto> getAll(Pageable pageable);
}
