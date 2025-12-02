package com.talhakoc.libraryproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddBookDto {
    private String bookName;
    private String bookAuthor;
    private String bookStatus;  // "Müsait" veya "Ödünç"
}