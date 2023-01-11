package com.linda.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksWebServiceController {

    private final BooksRepository booksRepository;

    @Autowired
    public BooksWebServiceController(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }


}
