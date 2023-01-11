package com.example.bookauthormanytomany.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Book {
    private String bookName;
    private Long price;
    private List<Author> authorEntity;
}
