package com.library.gestion_prestamos.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.library.gestion_prestamos.domain.model.Book;
import com.library.gestion_prestamos.domain.ports.in.GetAvailableBooksUseCase;
import com.library.gestion_prestamos.domain.ports.in.GetBorrowedBooksUseCase;
import com.library.gestion_prestamos.domain.ports.in.UpdateBookUseCase;
import com.library.gestion_prestamos.domain.ports.out.BookRepositoryPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService implements GetAvailableBooksUseCase, UpdateBookUseCase, GetBorrowedBooksUseCase {
    public final BookRepositoryPort bookRepositoryPort;

    @Override
    public List<Book> getAllAvailable() {
        return bookRepositoryPort.findAllAvailable();
    }

    @Override
    public void updateBookAvailability(Long bookId, Boolean disponible) {
        Book book = bookRepositoryPort.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado, con ID: " + bookId));
        book.setDisponible(disponible);
        bookRepositoryPort.save(book);
    }

    @Override
    public List<Book> getAllBorrowed() {
        return bookRepositoryPort.findAllBorrowed();
    }
}
