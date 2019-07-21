package com.github.outlaw1988.bookcatalog.service;

import com.github.outlaw1988.bookcatalog.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();
    Book getBook(Long id);
    void removeBook(Long id);
    void addBook(Book book);
    Long getIdToUse();

}
