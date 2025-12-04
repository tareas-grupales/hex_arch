package com.library.gestion_prestamos.application.port.input;

import com.library.gestion_prestamos.domain.model.Book;

public interface UpdateBookUseCase {
    Book updateAvailabilityById(Long id, Boolean disponible);
}
