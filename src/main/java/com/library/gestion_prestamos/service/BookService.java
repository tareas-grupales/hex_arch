package com.library.gestion_prestamos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.library.gestion_prestamos.domain.Book;
import com.library.gestion_prestamos.dto.BookDTO;
import com.library.gestion_prestamos.mapper.BookMapper;
import com.library.gestion_prestamos.repository.BookRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // for mapper and repo injection
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Transactional()
    public List<BookDTO> getAvailableBooks() {
        List<Book> books = bookRepository.findByDisponibleTrue();
        return books.stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional()
    public List<BookDTO> getBorrowedBooks() {
        List<Book> books = bookRepository.findByDisponibleFalse();
        return books.stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public BookDTO updateAvailabilityById(Long id, Boolean disponible) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado, con ID: " + id));

        book.setDisponible(disponible);
        bookRepository.save(book);

        return bookMapper.toDTO(book);
    }

}
