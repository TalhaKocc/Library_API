package com.talhakoc.libraryproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookDto {
    private Integer bookId;
    private String bookName;
    private String bookAuthor;
    private String bookStatus;
}

