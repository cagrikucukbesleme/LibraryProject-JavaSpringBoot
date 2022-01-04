package com.libraryproject.libraryproject.repository;

import com.libraryproject.libraryproject.entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorsRepository extends JpaRepository<Authors,Long> {
}
