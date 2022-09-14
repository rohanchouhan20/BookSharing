package com.booksharing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
@EnableAutoConfiguration
public class BookSharingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookSharingApplication.class, args);
	}

}
