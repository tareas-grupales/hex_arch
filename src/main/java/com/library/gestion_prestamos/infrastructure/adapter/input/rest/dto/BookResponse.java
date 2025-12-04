package com.library.gestion_prestamos.infrastructure.adapter.input.rest.dto;

import com.library.gestion_prestamos.domain.model.Book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private Long id;
    private String titulo;
    private String autor;
    private String isbn;
    private String genero;
    private Integer anioPublicacion;
    private Boolean disponible;

}
