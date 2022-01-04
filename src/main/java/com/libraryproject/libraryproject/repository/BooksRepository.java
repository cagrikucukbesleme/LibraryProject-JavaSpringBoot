package com.libraryproject.libraryproject.repository;

import com.libraryproject.libraryproject.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books,Long> {
}
