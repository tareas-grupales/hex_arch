package com.library.gestion_prestamos.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
//@Setter
@AllArgsConstructor
@Builder
public class Book {
    private Long id;
    private String titulo;
    private String autor;
    private String isbn;
    private String genero;
    private Integer anioPublicacion;
    private Boolean disponible;
}