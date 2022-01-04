package com.libraryproject.libraryproject.service;

import com.libraryproject.libraryproject.dto.BooksDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BooksService {
    BooksDto save(BooksDto booksDto);
    void delete(Long id);
    List<BooksDto> getAll();
    Page<BooksDto> getAll(Pageable pageable);
}
