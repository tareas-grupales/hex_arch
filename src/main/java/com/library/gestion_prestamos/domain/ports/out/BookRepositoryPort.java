package com.library.gestion_prestamos.domain.ports.out;

import java.util.List;
import java.util.Optional;

import com.library.gestion_prestamos.domain.model.Book;

public interface BookRepositoryPort {
    List<Book> findAllAvailable();
    List<Book> findAllBorrowed();
    Optional<Book> findById(Long id);
    Book save(Book book);
}
