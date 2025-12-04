package com.library.gestion_prestamos.application.port.input;

import com.library.gestion_prestamos.domain.model.Book;

import java.util.List;

public interface FindBookUseCase {

    List<Book> getAvailableBooks();
    List<Book> getBorrowedBooks();


}
