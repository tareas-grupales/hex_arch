package com.library.gestion_prestamos.application.usecase;

import com.library.gestion_prestamos.application.port.input.FindBookUseCase;
import com.library.gestion_prestamos.application.port.input.UpdateBookUseCase;
import com.library.gestion_prestamos.application.port.output.BookRepositoryPort;
import com.library.gestion_prestamos.domain.model.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Slf4j
public class UpdateBookUserCaseImpl implements UpdateBookUseCase {

    private final BookRepositoryPort bookRepositoryPort;

    @Override
    @Transactional(readOnly = true)
    public Book updateAvailabilityById(Long id, Boolean disponible) {
        return bookRepositoryPort.updateAvailabilityById(id, disponible);
    }
}
