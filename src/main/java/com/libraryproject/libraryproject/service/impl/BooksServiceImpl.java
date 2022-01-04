package com.libraryproject.libraryproject.service.impl;

import com.libraryproject.libraryproject.dto.BooksDto;
import com.libraryproject.libraryproject.repository.AuthorsRepository;
import com.libraryproject.libraryproject.repository.BooksRepository;
import com.libraryproject.libraryproject.service.BooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BooksServiceImpl implements BooksService {
    private final BooksRepository booksRepository;
    private final AuthorsRepository authorsRepository;

    @Override
    public BooksDto save(BooksDto booksDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<BooksDto> getAll() {
        return null;
    }

    @Override
    public Page<BooksDto> getAll(Pageable pageable) {
        return null;
    }
}
