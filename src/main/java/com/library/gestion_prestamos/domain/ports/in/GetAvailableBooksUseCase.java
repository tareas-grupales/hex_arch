package com.library.gestion_prestamos.domain.ports.in;

import java.util.List;

import com.library.gestion_prestamos.domain.model.Book;

public interface GetAvailableBooksUseCase {
    List<Book> getAllAvailable();
}
