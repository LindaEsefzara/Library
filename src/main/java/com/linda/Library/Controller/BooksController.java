package com.linda.Library.Controller;

import com.linda.Library.Model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BooksController {
    @Autowired
    public BooksController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private RestTemplate restTemplate;

    @GetMapping("/openlibrary")
    public ResponseEntity<String> getBooks() {
        String url = "https://openlibrary.org/works/OL45804W.json";
        String response = restTemplate.getForObject(url, Books.class).toString();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/booksAPI")
    public Books booksAPI() {

        final String url = "https://openlibrary.org/works/OL45804W.json";

        RestTemplate restTemplate = new RestTemplate();
        Books books;

        try {
            books = restTemplate.getForObject(url, Books.class);

            if (books != null) {
                System.out.println(
                        books.getCreated() + "" +
                                books.getType() + "" +
                                books.getLast_modified()
                );
            }
            return books;

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }
}
