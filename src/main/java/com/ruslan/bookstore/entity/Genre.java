package com.ruslan.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private long genreId;

    @Column(name = "genre_name")
    private String genreName;

    public Genre() {
    }

    @ManyToMany(mappedBy = "genres")
    @JsonIgnore
    private Set<Book> books;

    public Set<Book> getBooks() {
        return books;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return genreId == genre.genreId && Objects.equals(genreName, genre.genreName) && Objects.equals(books, genre.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genreId, genreName, books);
    }

    @Override
    public String toString() {
        return genreName;
    }
}
