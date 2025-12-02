package com.library.gestion_prestamos.domain.model;


import lombok.Builder;
import lombok.Data;

@Data // for getters, setters
@Builder // for builder pattern
public class Book {
    private Long id;
    private String titulo;
    private String autor;
    private String isbn;
    private String genero;
    private Integer anioPublicacion;
    private Boolean disponible;
}