package com.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    public List<Book> findByBookPriceGreaterThan(Double price);

    public List<Book> findByBookName(String name);

}
