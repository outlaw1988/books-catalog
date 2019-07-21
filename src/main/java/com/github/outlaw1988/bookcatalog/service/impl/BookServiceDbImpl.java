package com.github.outlaw1988.bookcatalog.service.impl;

import com.github.outlaw1988.bookcatalog.model.Book;
import com.github.outlaw1988.bookcatalog.repository.BookRepository;
import com.github.outlaw1988.bookcatalog.service.BookService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service
public class BookServiceDbImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceDbImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    @Override
    public void removeBook(Long id) {
        Book book = getBook(id);
        bookRepository.delete(book);
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

}
