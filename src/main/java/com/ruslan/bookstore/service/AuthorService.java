package com.ruslan.bookstore.service;

import com.ruslan.bookstore.Repository.AuthorRepository;
import com.ruslan.bookstore.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> listAllAuthors() {
        return authorRepository.findAll();
    }
}
