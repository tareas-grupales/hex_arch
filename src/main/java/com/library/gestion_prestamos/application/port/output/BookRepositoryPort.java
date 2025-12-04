package com.library.gestion_prestamos.application.port.output;

import com.library.gestion_prestamos.domain.model.Book;

import java.util.List;

public interface BookRepositoryPort {

    List<Book> getAvailable();
    List<Book> getBorrowed();
    Book updateAvailabilityById(Long id, Boolean disponible);
}
