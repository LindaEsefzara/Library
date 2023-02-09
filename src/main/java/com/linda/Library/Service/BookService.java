package com.linda.Library.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.awt.print.Book;
import java.util.List;

public interface BookService {
    public List<Book> findAllBooks();

    public List<Book> searchBooks(String keyword);

    public Book findBookById(Long id);

    public void createBook(Book book);

    public void updateBook(Book book);

    public void deleteBook(Long id);

    public Page<Book> findPaginated(Pageable pageable);

}
