package com.library.gestion_prestamos.domain.ports.in;

public interface UpdateBookUseCase {
    void updateBookAvailability(Long bookId, Boolean disponible);
}
