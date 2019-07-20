package com.github.outlaw1988.bookcatalog.controllers;

import com.github.outlaw1988.bookcatalog.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @GetMapping("/book-list")
    public String bookList(Model model) {

        List<Book> books = new ArrayList<>();
        books.add(new Book(1L, "Ogniem i mieczen", "1111",
                "Historyczna", "1879"));
        books.add(new Book(2L, "Lalka", "2222",
                "Nowela", "1855"));
        books.add(new Book(3L, "Janko Muzykant", "3333",
                "Nowela", "1822"));
        model.addAttribute("books", books);
        return "book-list";
    }

}
