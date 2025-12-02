package com.talhakoc.libraryproject.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.talhakoc.libraryproject.model.BookStatus;

import java.util.List;

public interface BookStatusRepository extends JpaRepository<BookStatus, Integer> {


    List<BookStatus> findByBook_BookId(Integer bookId);


    List<BookStatus> findByMember_MemberId(Integer memberId);
}

