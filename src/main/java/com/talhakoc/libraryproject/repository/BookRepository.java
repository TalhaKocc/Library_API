package com.talhakoc.libraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.talhakoc.libraryproject.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
