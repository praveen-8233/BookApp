package com.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByBookPriceGreaterThan(Double price);

    List<Book> findByBookName(String name);

    //SQL EXAMPLE
    @Query(value = "Select * from book", nativeQuery = true)
    List<Book> getAllBooks();

    //HQL Example
    @Query("from Book")
    List<Book> getBooks();

    @Query(value = "Select book_name from book", nativeQuery = true)
    List<String> getAllBooksName();

    @Query(" SELECT b.bookName FROM Book b " )
    List<String> getAllBooksName1();

    @Query(value = " Select book_id from book ", nativeQuery = true)
    List<Integer> getBookId();

    @Query(" Select b.id from Book b")
    List<Integer> getBookIds();
}
