package com.library.gestion_prestamos.infrastructure.config;

import com.library.gestion_prestamos.application.port.input.FindBookUseCase;
import com.library.gestion_prestamos.application.port.input.UpdateBookUseCase;
import com.library.gestion_prestamos.application.port.output.BookRepositoryPort;
import com.library.gestion_prestamos.application.usecase.FindBookUseCaseImpl;
import com.library.gestion_prestamos.application.usecase.UpdateBookUserCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HexagonalConfig {

    @Bean
    public FindBookUseCase userService(BookRepositoryPort bookRepositoryPort) {
        return new FindBookUseCaseImpl(bookRepositoryPort);
    }

    @Bean
    public UpdateBookUseCase updateUserUseCase(BookRepositoryPort bookRepositoryPort) {
        return new UpdateBookUserCaseImpl(bookRepositoryPort);
    }

}
