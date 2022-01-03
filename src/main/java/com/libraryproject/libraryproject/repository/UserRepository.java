package com.libraryproject.libraryproject.repository;

import com.libraryproject.libraryproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


//database işlemleri için hazır metodlar tanımlıyoruz.
//@Repository eklemeye gerek yok JpaRepo eklediğimizde spring otomatik algılıyor
public interface UserRepository extends JpaRepository<User, Long>{


}
