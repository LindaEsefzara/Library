package com.linda.Library;

import jakarta.persistence.*;

@Entity
@Table(name= "Books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String authorName;
    public String booksName;
    public Integer ISBN;

    public Books(String authorName, String booksName, Integer ISBN) {
        this.authorName = authorName;
        this.booksName = booksName;
        this.ISBN = ISBN;
    }

    public Books() {

    }
    public long getId() {
        return id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBooksName() {
        return booksName;
    }

    public void setBooksName(String booksName) {
        this.booksName = booksName;
    }

    public Integer getISBN() {
        return ISBN;
    }

    public void setISBN(Integer ISBN) {
        this.ISBN = ISBN;
    }
}
