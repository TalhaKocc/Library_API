package com.talhakoc.libraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talhakoc.libraryproject.model.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
