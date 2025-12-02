package com.library.gestion_prestamos.application.service;

import com.library.gestion_prestamos.application.port.input.BookService;
import com.library.gestion_prestamos.application.port.input.BookRepositoryPort;
import com.library.gestion_prestamos.domain.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepositoryPort bookRepositoryPort;


    @Override
    public List<Book> getAvailableBooks() {
        return bookRepositoryPort.getAvailable();
    }

    @Override
    public List<Book> getBorrowedBooks() {
        return bookRepositoryPort.getBorrowed();
    }

    @Override
    public Book updateAvailabilityById(Long id, Boolean disponible) {
        return bookRepositoryPort.updateAvailabilityById(id, disponible);
    }
}
