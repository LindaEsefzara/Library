package com.linda.Library;
import com.linda.Library.Repository.UserRepository;
import com.linda.Library.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class LibraryApplication extends SpringBootServletInitializer {


	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);

	}
}
