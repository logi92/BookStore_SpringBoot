package com.ruslan.bookstore.service;

import com.ruslan.bookstore.Repository.GenreRepository;
import com.ruslan.bookstore.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    private GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> listAllGenres(){
        return genreRepository.findAll();
    }
}
