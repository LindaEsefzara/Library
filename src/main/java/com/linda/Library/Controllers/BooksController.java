package com.linda.Library.Controllers;

import com.linda.Library.Books;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BooksController {
    @GetMapping("/callBooksAip")
    public Books callBooksAip(){
        final String url = "https://openlibrary.org/works/OL45804W.json";

        RestTemplate restTemplate = new RestTemplate();
        Books books;

        try{
            books = restTemplate.getForObject(url, Books.class);

            if (books != null){
                System.out.printf(
                        books.getBooksName().toLowerCase()+ " " +
                        books.getAuthorName().toLowerCase()+" "+
                        books.getISBN()
                );
            }
            return books;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
