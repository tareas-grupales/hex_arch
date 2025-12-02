package com.library.gestion_prestamos.infrastructure.adapter.in.web.dto;

import com.library.gestion_prestamos.domain.model.Book;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookResponseDTO {
    private Long id;
    private String titulo;
    private String autor;
    private String isbn;
    private String genero;
    private Integer anioPublicacion;
    private Boolean disponible;

    public static BookResponseDTO fromDomain(Book book) {
        return BookResponseDTO.builder()
                .id(book.getId())
                .titulo(book.getTitulo())
                .autor(book.getAutor())
                .isbn(book.getIsbn())
                .genero(book.getGenero())
                .anioPublicacion(book.getAnioPublicacion())
                .disponible(book.getDisponible())
                .build();
    }
}
