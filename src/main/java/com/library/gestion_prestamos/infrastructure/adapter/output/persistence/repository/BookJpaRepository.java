package com.library.gestion_prestamos.infrastructure.adapter.output.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.library.gestion_prestamos.infrastructure.adapter.output.persistence.entity.BookEntity;

interface BookJpaRepository extends JpaRepository<BookEntity, Long> {

    @Query("SELECT b FROM BookEntity b WHERE b.disponible = true")
    List<BookEntity> findByDisponibleTrue();
    
    @Query("SELECT b FROM BookEntity b WHERE b.disponible = false")
    List<BookEntity> findAllBorrowed();
}
