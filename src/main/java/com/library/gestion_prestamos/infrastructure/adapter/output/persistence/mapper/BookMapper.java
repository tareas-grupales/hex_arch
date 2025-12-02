package com.library.gestion_prestamos.infrastructure.adapter.output.persistence.mapper;

import org.springframework.stereotype.Component;

import com.library.gestion_prestamos.domain.model.Book;
import com.library.gestion_prestamos.infrastructure.adapter.output.persistence.entity.BookEntity;

@Component
public class BookMapper {
    
    public Book toDomain(BookEntity entity) {
        if (entity == null) {
            return null;
        }
        return Book.builder()
                .id(entity.getId())
                .titulo(entity.getTitulo())
                .autor(entity.getAutor())
                .isbn(entity.getIsbn())
                .genero(entity.getGenero())
                .anioPublicacion(entity.getAnioPublicacion())
                .disponible(entity.getDisponible())
                .build();
    }

    public BookEntity toEntity(Book book) {
        if (book == null) {
            return null;
        }
        return new BookEntity(
                book.getId(),
                book.getTitulo(),
                book.getAutor(),
                book.getIsbn(),
                book.getGenero(),
                book.getAnioPublicacion(),
                book.getDisponible()
        );
    }
}
