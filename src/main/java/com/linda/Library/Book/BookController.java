package com.linda.Library.Book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class BookController {}
    /*@GetMapping("/createAPI")
    public Book createAPI(){

        final String url = "https://openlibrary.org/works/OL45804W.json";

        RestTemplate restTemplate = new RestTemplate();
        Book book;

        try{
            book = restTemplate.getForObject(url, Book.class);

            if(book !=null){
                System.out.println(
                        book.getTitle() + "" +
                        book.getKey()+ "" +
                                book.CreatedObject

                );
            }
            return book;

        }catch(Exception e){
            e.printStackTrace();
        }


        return null ;
    }
}
