package com.library.gestion_prestamos.infrastructure.adapter.output.persistence.mapper;

import com.library.gestion_prestamos.infrastructure.adapter.input.rest.dto.BookRequest;
import com.library.gestion_prestamos.infrastructure.adapter.input.rest.dto.BookResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;

import com.library.gestion_prestamos.domain.model.Book;
import com.library.gestion_prestamos.infrastructure.adapter.output.persistence.entity.BookEntity;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book toDomain(BookEntity entity);

    // Request to Domain (for new users)
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "titulo", source = "titulo")
    @Mapping(target = "autor", source = "autor")
    @Mapping(target = "isbn", source = "isbn")
    @Mapping(target = "genero", source = "genero")
    @Mapping(target = "anioPublicacion", source = "anioPublicacion")
    @Mapping(target = "disponible", source = "disponible")
    Book toDomain(BookRequest request);

    // Domain to Entity
    @Mapping(target = "id", source = "id")
    @Mapping(target = "titulo", source = "titulo")
    @Mapping(target = "autor", source = "autor")
    @Mapping(target = "isbn", source = "isbn")
    @Mapping(target = "genero", source = "genero")
    @Mapping(target = "anioPublicacion", source = "anioPublicacion")
    @Mapping(target = "disponible", source = "disponible")
    BookEntity toEntity(Book domain);

    // Domain to Response
    @Mapping(target = "id", source = "id")
    @Mapping(target = "titulo", source = "titulo")
    @Mapping(target = "autor", source = "autor")
    @Mapping(target = "isbn", source = "isbn")
    @Mapping(target = "genero", source = "genero")
    @Mapping(target = "anioPublicacion", source = "anioPublicacion")
    @Mapping(target = "disponible", source = "disponible")
    BookResponse toResponse(Book domain);


    List<Book> toDomain(List<BookEntity> entities);
    List<BookResponse> toResponse(List<Book> books);

}
