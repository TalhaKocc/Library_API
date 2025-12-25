package com.talhakoc.libraryproject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talhakoc.libraryproject.dto.book.AddBookDto;
import com.talhakoc.libraryproject.dto.book.BookListDto;
import com.talhakoc.libraryproject.dto.book.UpdateBookDto;
import com.talhakoc.libraryproject.dto.book_status.BorrowBookDto;
import com.talhakoc.libraryproject.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

	private final BookService bookService;

	@GetMapping
	public List<BookListDto> listBooks() {
		return bookService.listBooks();
	}

	@PostMapping
	public String addBook(@RequestBody AddBookDto dto) {
		bookService.addBook(dto);
		return "Kitap başarıyla eklendi.";
	}

	@PostMapping("/{bookId}/borrow")
	public String borrowBook(@PathVariable Integer bookId, @RequestBody BorrowBookDto dto) {

		bookService.borrowBook(bookId, dto);
		return "Kitap ödünç verildi.";
	}

	@PostMapping("/{bookId}/return")
	public String returnBook(@PathVariable Integer bookId) {
		bookService.returnBook(bookId);
		return "Kitap iade edildi.";
	}

	@PutMapping
	public String updateBook(@RequestBody UpdateBookDto dto) {
		bookService.updateBook(dto);
		return "Kitap güncellendi.";
	}

	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable Integer id) {
		bookService.deleteBook(id);
		return "Kitap silindi.";
	}
}
