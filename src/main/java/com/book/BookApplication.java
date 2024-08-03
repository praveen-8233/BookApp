package com.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BookApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(BookApplication.class, args);
		BookRepository repo = context.getBean(BookRepository.class);
		//For Saving Data save method will save data if it is not exist if data is present then it will update data
		/*Book b = new Book();
		b.setBookId(106);
		b.setBookName("Thread");
		b.setBookPrice(4000.00);
		repo.save(b);*/
		/*
		List<Book> list  = repo.findAll();
		for(Book b : list){
			System.out.println(b);
		}
		*/
		// Printing the retrieved books for both ids which i am passing
		List<Integer> ids = Arrays.asList(101, 102);
		List<Book> allById = repo.findAllById(ids);
		for (Book book : allById) {
			System.out.println(book);

		}

	}
}
