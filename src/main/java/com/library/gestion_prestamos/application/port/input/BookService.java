package com.library.gestion_prestamos.application.port.input;

import com.library.gestion_prestamos.domain.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAvailableBooks();
    List<Book> getBorrowedBooks();
    Book updateAvailabilityById(Long id, Boolean disponible);

}
