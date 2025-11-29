package com.library.gestion_prestamos.mapper;

import org.springframework.stereotype.Component;

import com.library.gestion_prestamos.domain.Book;
import com.library.gestion_prestamos.dto.BookDTO;

@Component
public class BookMapper {
    public BookDTO toDTO(Book book) {
        if (book == null) return null;

        return BookDTO.builder()
                .id(book.getId())
                .titulo(book.getTitulo())
                .autor(book.getAutor())
                .isbn(book.getIsbn())
                .genero(book.getGenero())
                .anioPublicacion(book.getAnioPublicacion())
                .disponible(book.getDisponible())
                .build();
    }

    public Book toEntity(BookDTO dto) {
        if (dto == null) return null;

        return Book.builder()
                .id(dto.getId())
                .titulo(dto.getTitulo())
                .autor(dto.getAutor())
                .isbn(dto.getIsbn())
                .genero(dto.getGenero())
                .anioPublicacion(dto.getAnioPublicacion())
                .disponible(dto.getDisponible())
                .build();
    }
}
