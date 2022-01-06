package com.libraryproject.libraryproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class LibraryProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(LibraryProjectApplication.class, args);
	}

}
