package com.library.gestion_prestamos.infrastructure.adapter.out.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.library.gestion_prestamos.infrastructure.adapter.out.persistence.entity.BookEntity;

public interface SpringDataBookRepository extends JpaRepository<BookEntity, Long> {
    
    List<BookEntity> findByDisponibleTrue();
    
    @Query("SELECT b FROM BookEntity b WHERE b.disponible = false")
    List<BookEntity> findAllBorrowed();
}
