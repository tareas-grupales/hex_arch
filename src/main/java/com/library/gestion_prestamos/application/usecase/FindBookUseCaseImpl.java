package com.library.gestion_prestamos.application.usecase;

import com.library.gestion_prestamos.application.port.input.FindBookUseCase;
import com.library.gestion_prestamos.application.port.output.BookRepositoryPort;
import com.library.gestion_prestamos.domain.model.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Slf4j
public class FindBookUseCaseImpl implements FindBookUseCase {
    private final BookRepositoryPort bookRepositoryPort;

    @Override
    @Transactional(readOnly = true)
    public List<Book> getAvailableBooks() {
        return bookRepositoryPort.getAvailable();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> getBorrowedBooks() {
        return bookRepositoryPort.getBorrowed();
    }
}
