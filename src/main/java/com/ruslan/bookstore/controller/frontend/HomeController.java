package com.ruslan.bookstore.controller.frontend;

import com.ruslan.bookstore.entity.Book;
import com.ruslan.bookstore.service.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    private BookServices bookServices;

    @Autowired
    public HomeController(BookServices bookServices) {
        this.bookServices = bookServices;
    }

    @RequestMapping("/home")
    public String listBooks(Model model) {
        List<Book> bookList = bookServices.listBooks();
        model.addAttribute("books", bookList);
        return "book_list_page";
    }
}
