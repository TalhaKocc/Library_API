package com.talhakoc.libraryproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.talhakoc.libraryproject")
public class LibraryprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryprojectApplication.class, args);
	}

}
