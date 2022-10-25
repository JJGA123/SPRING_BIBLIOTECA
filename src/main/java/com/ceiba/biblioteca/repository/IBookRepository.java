package com.ceiba.biblioteca.repository;

import com.ceiba.biblioteca.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<BookEntity, String> {

    BookEntity findByIsbn(String isbn);

}
