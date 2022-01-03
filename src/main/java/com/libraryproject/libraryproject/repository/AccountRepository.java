package com.libraryproject.libraryproject.repository;

import com.libraryproject.libraryproject.entity.User;
import com.libraryproject.libraryproject.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<UserAccount, Long> {

}
