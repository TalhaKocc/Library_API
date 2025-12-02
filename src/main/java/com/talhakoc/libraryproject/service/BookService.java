package com.talhakoc.libraryproject.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.talhakoc.libraryproject.dto.AddBookDto;
import com.talhakoc.libraryproject.dto.BookListDto;
import com.talhakoc.libraryproject.dto.BorrowBookDto;
import com.talhakoc.libraryproject.dto.UpdateBookDto;
import com.talhakoc.libraryproject.model.Book;
import com.talhakoc.libraryproject.model.BookStatus;
import com.talhakoc.libraryproject.model.Member;
import com.talhakoc.libraryproject.repository.BookRepository;
import com.talhakoc.libraryproject.repository.BookStatusRepository;
import com.talhakoc.libraryproject.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final BookStatusRepository bookStatusRepository;

    // ---------------------------------------------------------
    // 1) Tüm kitapları listele → mapping: Entity → BookListDto
    // ---------------------------------------------------------
    public List<BookListDto> listBooks() {
        return bookRepository.findAll()
                .stream()
                .map(book -> new BookListDto(
                        book.getBookId(),
                        book.getBookName(),
                        book.getBookAuthor(),
                        book.getBookStatus()
                ))
                .toList();
    }

    // ---------------------------------------------------------
    // 2) Yeni kitap ekle → mapping: AddBookDto → Entity
    // ---------------------------------------------------------
    public void addBook(AddBookDto dto) {

        Book book = new Book();
        book.setBookName(dto.getBookName());
        book.setBookAuthor(dto.getBookAuthor());
        book.setBookStatus(dto.getBookStatus());

        bookRepository.save(book);
    }

    // ---------------------------------------------------------
    // 3) Kitap ödünç alma → mapping: BorrowBookDto → BookStatus
    // ---------------------------------------------------------
    public void borrowBook(Integer bookId, BorrowBookDto dto) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Kitap bulunamadı"));

        if (!book.getBookStatus().equals("Müsait")) {
            throw new RuntimeException("Kitap zaten ödünç alınmış.");
        }

        Member member = memberRepository.findById(dto.getMemberId())
                .orElseThrow(() -> new RuntimeException("Üye bulunamadı"));

        // Kitap durumunu güncelle
        book.setBookStatus("Ödünç");
        bookRepository.save(book);

        // Ödünç kayıt ekle
        BookStatus status = new BookStatus();
        status.setBook(book);
        status.setMember(member);
        status.setStatusDate(LocalDate.now());

        bookStatusRepository.save(status);
    }

    // ---------------------------------------------------------
    // 4) Kitap iade → ReturnBookDto gerekmez
    // ---------------------------------------------------------
    public void returnBook(Integer bookId) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Kitap bulunamadı"));

        if (book.getBookStatus().equals("Müsait")) {
            throw new RuntimeException("Kitap zaten müsait.");
        }

        book.setBookStatus("Müsait");
        bookRepository.save(book);

        // İade kaydı eklemek istersek:
        BookStatus status = new BookStatus();
        status.setBook(book);
        status.setMember(null); // istersek null bırakırız
        status.setStatusDate(LocalDate.now());
        bookStatusRepository.save(status);
    }

    // ---------------------------------------------------------
    // 5) Kitap güncelle → mapping: UpdateBookDto → Entity
    // ---------------------------------------------------------
    public void updateBook(UpdateBookDto dto) {

        Book book = bookRepository.findById(dto.getBookId())
                .orElseThrow(() -> new RuntimeException("Kitap bulunamadı"));

        book.setBookName(dto.getBookName());
        book.setBookAuthor(dto.getBookAuthor());
        book.setBookStatus(dto.getBookStatus());

        bookRepository.save(book);
    }

    // ---------------------------------------------------------
    // 6) Kitap sil
    // ---------------------------------------------------------
    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

}

