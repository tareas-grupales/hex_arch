package com.library.gestion_prestamos.infrastructure.adapter.output.persistence.repository;

import com.library.gestion_prestamos.application.port.input.BookRepositoryPort;
import com.library.gestion_prestamos.domain.model.Book;
import com.library.gestion_prestamos.infrastructure.adapter.output.persistence.entity.BookEntity;
import com.library.gestion_prestamos.infrastructure.adapter.output.persistence.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BookRepositoryAdapter implements BookRepositoryPort {

    private final BookJpaRepository bookJpaRepository;
    private final BookMapper bookMapper;

    @Override
    public List<Book> getAvailable() {
        return bookJpaRepository.findByDisponibleTrue().stream()
                .map(bookMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getBorrowed() {
        return bookJpaRepository.findAllBorrowed().stream()
                .map(bookMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Book updateAvailabilityById(Long id, Boolean disponible) {
        BookEntity entity = bookJpaRepository.findById(id).orElse(null);
        if (entity == null) {
            return null;
        }
        entity.setDisponible(disponible);
        BookEntity savedEntity = bookJpaRepository.save(entity);
        return bookMapper.toDomain(savedEntity);
    }
}
