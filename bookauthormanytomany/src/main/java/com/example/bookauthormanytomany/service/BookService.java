package com.example.bookauthormanytomany.service;

import com.example.bookauthormanytomany.entity.BookEntity;
import com.example.bookauthormanytomany.mapper.BookMapper;
import com.example.bookauthormanytomany.model.Book;
import com.example.bookauthormanytomany.model.BookResponse;
import com.example.bookauthormanytomany.repository.BookRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class BookService {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookRepository bookRepository;

    public BookResponse addBook(Book book){
        BookEntity bookEntity = new BookEntity();
        bookEntity=bookMapper.modelToEntity(book);
        bookRepository.save(bookEntity);
        BookResponse bookResponse = new BookResponse();
        bookResponse.setId(bookEntity.getId());
        log.info("book is added");
        return bookResponse;
    }

    public Book getById(Long id){
        Optional<BookEntity> optionalBookEntity = bookRepository.findById(id);
//        Optional<BookEntity> optionalBookEntity = bookRepository.findByQuery(id);
      //  Optional<BookEntity> optionalBookEntity = bookRepository.findAuthorById(id);
        Book book =new Book();
        if (optionalBookEntity.isPresent()){
            book= bookMapper.entityToModel(optionalBookEntity.get());
            log.info("id received successfully");
        }else {
            log.info("");
        }
        return book;
    }

    public void updateBook(Long id,Book book){
        Optional<BookEntity> optionalBookEntity=bookRepository.findById(id);
        if (optionalBookEntity.isPresent()){
            optionalBookEntity.get().setBookName(book.getBookName());
            optionalBookEntity.get().setPrice(book.getPrice());
            bookRepository.save(optionalBookEntity.get());
            log.info("book update with id");
        }else {
            log.info("book id is not found");
        }

    }

    public void deleteById(Long id){
        Optional<BookEntity> optionalBookEntity=bookRepository.findById(id);
        if (optionalBookEntity.isPresent()){
            bookRepository.deleteById(id);
            log.info("delete successfully by id");
        }else {
            log.info("id is not found");
        }
    }
    public List<Book> allBooks() {
        List<Book> books = bookMapper.entityToList(bookRepository.findAll());
        return books;
    }
}
