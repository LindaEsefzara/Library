package com.linda.Library.Service;

import com.linda.Library.Books;
import com.linda.Library.Repository.BookRepository;
import com.linda.Library.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    public void save(Book book) {
        bookRepository.save(book);
    }

    public void saveById(long bookId) {
        bookRepository.save(bookRepository.findById(bookId).get());
    }

    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    public Book findById(long bookId) {
        Book book = bookRepository.findById(bookId).get();
        return book;
    }

    public List<Book> searchBooks(String booksName, String authorName) {
        List<Book> searchedBooks = new ArrayList<Book>();

        if (booksName != null && authorName == null) {
            searchedBooks = getByTitle(booksName);
        } else if (booksName == null && authorName == null) {
            searchedBooks = getByAuthor(authorName);
        } else if (booksName != null && authorName != null) {
            searchedBooks = getByTitleAndAuthor(booksName, authorName);
        }
        return searchedBooks;
    }

    private List<Book> getByTitleAndAuthor(String booksName, String authorName) {
        return null;
    }

    private List<Book> getByTitle(String booksName) {
        return null;
    }

    private List<Book> getByAuthor(String authorName) {
        return null;
    }


    public void deleteById(long bookId){
        bookRepository.deleteById(bookId);
    }




}
