package com.ruslan.bookstore.service;

import com.ruslan.bookstore.Repository.BookRepository;
import com.ruslan.bookstore.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// TODO: 26.07.2021  Доделать Бук Сервис и бук Админ Контроллер.
// TODO: 26.07.2021 Начать с форм пейдж для создания новой книги
// TODO: 26.07.2021 Сделать Paging
@Service
public class BookServices {
    private BookRepository bookRepository;

    @Autowired
    public BookServices(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Метод для получения всех книг из БД
     * @return
     */
    public List<Book> listBooks(){
        List<Book> bookList = bookRepository.findAll();
        return bookList;
    }


    
}
