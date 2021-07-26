package com.ruslan.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="author_id")
    private long authorId;

    @Column(name = "author_name")
    private String name;

    public Author() {
    }

    @ManyToMany(mappedBy = "authors")
    @JsonIgnore
    private Set<Book> books;

    public Set<Book> getBooks() {
        return books;
    }

    public long getAuthorId() {
        return authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return name ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return authorId == author.authorId && Objects.equals(name, author.name) && Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, name, books);
    }
}
