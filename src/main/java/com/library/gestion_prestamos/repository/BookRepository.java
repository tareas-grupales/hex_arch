package com.library.gestion_prestamos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.library.gestion_prestamos.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    // available books
    List<Book> findByDisponibleTrue();

    // borrowed books
    List<Book> findByDisponibleFalse();

    // find by author
    List<Book> findByAutorContainingIgnoreCase(String autor);



}
