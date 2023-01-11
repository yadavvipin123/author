package com.example.bookauthormanytomany.mapper;

import com.example.bookauthormanytomany.entity.BookEntity;
import com.example.bookauthormanytomany.model.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookEntity modelToEntity(Book book);
    Book entityToModel(BookEntity bookEntity);
    List<Book> entityToList(List<BookEntity> all);
}
