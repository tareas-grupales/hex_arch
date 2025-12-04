package com.library.gestion_prestamos.infrastructure.adapter.output.persistence.repository;

import com.library.gestion_prestamos.application.port.output.BookRepositoryPort;
import com.library.gestion_prestamos.domain.model.Book;
import com.library.gestion_prestamos.infrastructure.adapter.output.persistence.entity.BookEntity;
import com.library.gestion_prestamos.infrastructure.adapter.output.persistence.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BookRepositoryAdapter implements BookRepositoryPort {

    private final BookJpaRepository bookJpaRepository;
    private final BookMapper bookMapper;


    @Override
    public List<Book> getAvailable() {
        List<BookEntity> entities = this.bookJpaRepository.findByDisponibleTrue();
        return this.bookMapper.toDomain(entities);
    }

    @Override
    public List<Book> getBorrowed() {
        List<BookEntity> entities = this.bookJpaRepository.findAllBorrowed();
        return this.bookMapper.toDomain(entities);

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
