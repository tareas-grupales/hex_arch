package com.library.gestion_prestamos.application.service;

import com.library.gestion_prestamos.application.port.input.BookService;
import com.library.gestion_prestamos.application.port.output.BookRepositoryPort;
import com.library.gestion_prestamos.domain.model.Book;

import java.util.List;

public class BookServiceImpl implements BookService {

    private final BookRepositoryPort bookRepositoryPort;


    @Override
    public List<Book> getAvailableBooks() {
        return List.of();
    }

    @Override
    public List<Book> getBorrowedBooks() {
        return List.of();
    }

    @Override
    public Book updateAvailabilityById(Long id, Boolean disponible) {
        return null;
    }
}
