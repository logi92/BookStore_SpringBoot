package com.ruslan.bookstore.controller.admin;

import com.ruslan.bookstore.entity.Book;
import com.ruslan.bookstore.service.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class BookController {
    private BookServices bookServices;

    @Autowired
    public BookController(BookServices bookServices) {
        this.bookServices = bookServices;
    }

    @GetMapping("/list_books")
    @ResponseBody
    public List<Book> listBooks() {
        return bookServices.listBooks();
    }

    @PostMapping("/create_book")
    public void createBook(@RequestBody Book book) {

    }
}
