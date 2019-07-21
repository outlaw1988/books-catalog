package com.github.outlaw1988.bookcatalog.controllers;

import com.github.outlaw1988.bookcatalog.model.Book;
import com.github.outlaw1988.bookcatalog.service.BookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;


@Controller
public class BookController {

    private final BookServiceImpl bookService;

    // @Autowired
    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String index() {
        return "forward:/book-list";
    }

    @GetMapping("/book-list")
    public String bookList(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "book-list";
    }

    @GetMapping("/book-details/{id}")
    public String bookDetails(Model model, @PathVariable("id") Long id) {
        Book book = bookService.getBook(id);
        model.addAttribute("book", book);
        return "book-details";
    }

    @GetMapping("/book-details2")
    public String bookDetails2(Model model, @PathParam("id") Long id) {
        Book book = bookService.getBook(id);
        model.addAttribute("book", book);
        return "book-details";
    }

    @PostMapping("/delete-book")
    public String removeBook(HttpServletRequest request) {
        String id = request.getParameter("id");
        bookService.removeBook(Long.valueOf(id));
        return "redirect:/book-list";
    }

    @GetMapping("/save-book")
    public String saveBookGet(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "add-book";
    }

    @PostMapping("/save-book")
    public String saveBookPost(@ModelAttribute Book book) {
        bookService.addBook(book);
        return "redirect:/book-list";
    }

}
