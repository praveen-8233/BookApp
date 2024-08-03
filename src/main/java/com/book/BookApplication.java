package com.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class BookApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(BookApplication.class, args);
        BookRepository repo = context.getBean(BookRepository.class);

        // This is find By Method where we will provide our method with find by and we have to use property name
        //with find by so it will work.
        List<Book> byBookPriceGreaterThan = repo.findByBookPriceGreaterThan(2500.00);
        for (Book b : byBookPriceGreaterThan) {
            System.out.print(b);
            System.out.println(" Find By Method End ");
        }

        List<Book> byName = repo.findByBookName("Angular");
        for (Book b : byName) {
            System.out.println(b);
            System.out.println(" Find By Name Method End ");
        }

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
		/*List<Integer> ids = Arrays.asList(101, 102);
		List<Book> allById = repo.findAllById(ids);
		for (Book book : allById) {
			System.out.println(book);

		}*/

        List<Book> books = repo.getAllBooks();
        for (Book b : books) {
            System.out.print(b);
            System.out.println(" Custom SQL Ended ");
        }

        List<Book> books1 = repo.getBooks();
		for(Book b : books1){
			System.out.print(b);
			System.out.println(" HQL method Ended ");
		}
        System.out.println(" This is counting of records ");
        Long num  = repo.count();
        System.out.println(num);

        System.out.println(" This is the names of Books from SQL");
        List<String> names = repo.getAllBooksName();
        System.out.println(names);

        System.out.println(" This is the names of Books from HQL ");
        List<String> names1  = repo.getAllBooksName1();
        System.out.println(names1);

        System.out.println(" This is book id from SQL ");
        List<Integer> id = repo.getBookId();
        System.out.println(id);

        System.out.println(" This is books id from HQL ");
        List<Integer> ids = repo.getBookIds();
        System.out.println(ids);


    }
}

