package com.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    public List<Book> findByBookPriceGreaterThan(Double price);

    public List<Book> findByBookName(String name);

    //SQL EXAMPLE
    @Query(value = "Select * from book", nativeQuery = true)
    public List<Book> getAllBooks();

    //HQL Example
    @Query("from Book")
    public List<Book> getBooks();

    @Query(value = "Select book_name from book", nativeQuery = true)
    public List<String> getAllBooksName();

    @Query(" SELECT b.bookName FROM Book b " )
    public List<String> getAllBooksName1();

    @Query(value = " Select book_id from book ", nativeQuery = true)
    public List<Integer> getBookId();

    @Query(" Select b.id from Book b")
    public List<Integer> getBookIds();
}
