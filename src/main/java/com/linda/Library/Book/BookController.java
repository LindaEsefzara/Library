package com.linda.Library.Book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BookController {

    /*@GetMapping("/bookAip")
    public Book bookAip(){

        final String url = "https://openlibrary.org/works/OL15626917W.json";

        RestTemplate restTemplate = new RestTemplate();
        Book book;

        try{
            book = restTemplate.getForObject(url, Book.class);

            if(book !=null){
                System.out.println(
                        Book.Author.class+ "" +
                        Book.Created.class+ ""+
                        Book.Root.class+ "" +
                        Book.Author2.class+ "" +
                        Book.Description.class+"" +
                        Book.LastModified.class+"" +
                        Book.Type.class

                );
            }
            return book;

        }catch(Exception e){
            e.printStackTrace();
        }


        return null;
    }
    @GetMapping("/Book")
    public String booksDisplayer(){
        return "bookAip.html";
    }*/



}
