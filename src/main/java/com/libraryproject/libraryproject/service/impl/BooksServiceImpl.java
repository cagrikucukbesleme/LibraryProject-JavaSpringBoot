package com.libraryproject.libraryproject.service.impl;

import com.libraryproject.libraryproject.dto.BooksDto;
import com.libraryproject.libraryproject.dto.UserDto;
import com.libraryproject.libraryproject.entity.Books;
import com.libraryproject.libraryproject.entity.User;
import com.libraryproject.libraryproject.repository.AuthorsRepository;
import com.libraryproject.libraryproject.repository.BooksRepository;
import com.libraryproject.libraryproject.service.BooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BooksServiceImpl implements BooksService {
    private final BooksRepository booksRepository;
    private final AuthorsRepository authorsRepository;

    @Override
    @Transactional
    public BooksDto save(BooksDto booksDto) {
        Books books=new Books();

        books.setBookName(booksDto.getBookName());
        books.setIsBookActive(booksDto.getIsBookActive());
        books.setBooksType(booksDto.getBooksType());
//        books.setAuthors(booksDto.getAuthors());
        booksRepository.save(books);
        booksDto.setId(books.getId());
        return booksDto;
    }

    @Override
    @Transactional
    public BooksDto updateBook(BooksDto booksDto) {
        Books book1s=new Books();

        book1s=booksRepository.getById(booksDto.getId());
        final BooksDto booksDto1=new BooksDto();
        booksDto1.setId(book1s.getId());
        booksDto1.setBookName(book1s.getBookName());
        booksDto1.setIsBookActive(book1s.getIsBookActive());
        booksDto1.setBooksType(book1s.getBooksType());
        return booksDto1;
    }

    @Override
    @Transactional
    public void delete(long id) {
        Books books=new Books();
        booksRepository.deleteById(id);

    }



    @Override
    @Transactional
    public List<BooksDto> getAll() {
        List<Books> books1=booksRepository.findAll();
        List<BooksDto> booksDtos=new ArrayList<>();
        books1.forEach(it->{
            BooksDto booksDto=new BooksDto();
            booksDto.setId(it.getId());
            booksDto.setBookName(it.getBookName());
            booksDto.setIsBookActive(it.getIsBookActive());
            booksDto.setBooksType(it.getBooksType());
//            booksDto.setAuthors(it.getAuthors());
            booksDtos.add(booksDto);
        });

        return booksDtos;
    }

    @Override
    @Transactional
    public BooksDto getBookById(long id) {
        Books books=new Books();
        BooksDto booksDto=new BooksDto();
        books=booksRepository.getById(id);
        booksDto.setId(books.getId());
        return booksDto;
    }

    @Override
    @Transactional
    public Page<BooksDto> getAll(Pageable pageable) {
        return null;
    }
}
