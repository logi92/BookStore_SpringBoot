package com.ruslan.bookstore.controller.admin;

import com.ruslan.bookstore.Repository.AuthorRepository;
import com.ruslan.bookstore.Repository.GenreRepository;
import com.ruslan.bookstore.entity.Author;
import com.ruslan.bookstore.entity.Book;
import com.ruslan.bookstore.entity.Genre;
import com.ruslan.bookstore.service.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class BookController {
    private BookServices bookServices;
    private AuthorRepository authorRepository;
    private GenreRepository genreRepository;

    @Autowired
    public BookController(BookServices bookServices, AuthorRepository authorRepository, GenreRepository genreRepository) {
        this.bookServices = bookServices;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }

    @GetMapping("/list_books")
    @ResponseBody
    public List<Book> listBooks() {
        return bookServices.listBooks();
    }

    // TODO: 27.07.2021 Сделать метод который перенаправляет в форму "создания книги",
    // TODO: 27.07.2021 в эту форму нужно передавать список жанров и авторов
    @PostMapping("/create_book")
    public String showBookNewForm(Model model) {
        List<Author> authorList = authorRepository.findAll();
        List<Genre> genreList = genreRepository.findAll();

        model.addAttribute("authors", authorList);
        model.addAttribute("genres", genreList);

        return "";
    }
}
