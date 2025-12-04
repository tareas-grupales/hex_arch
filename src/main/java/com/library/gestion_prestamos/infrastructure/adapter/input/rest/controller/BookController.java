package com.library.gestion_prestamos.infrastructure.adapter.input.rest.controller;

import com.library.gestion_prestamos.application.port.input.FindBookUseCase;
import com.library.gestion_prestamos.application.port.input.UpdateBookUseCase;
import com.library.gestion_prestamos.domain.model.Book;
import com.library.gestion_prestamos.infrastructure.adapter.input.rest.dto.BookResponse;
import com.library.gestion_prestamos.infrastructure.adapter.output.persistence.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final FindBookUseCase findBookUseCase;
    private final UpdateBookUseCase updateBookUseCase;
    private final BookMapper mapper;


    @GetMapping("/available")
    public ResponseEntity<List<BookResponse>> getAvailableBooks() {

        List<Book> books = this.findBookUseCase.getAvailableBooks();
        List<BookResponse> responses = this.mapper.toResponse(books);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/borrowed")
    public ResponseEntity<List<BookResponse>> getBorrowedBooks() {

        List<Book> books = this.findBookUseCase.getBorrowedBooks();
        List<BookResponse> responses = this.mapper.toResponse(books);
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}/availability")
    public ResponseEntity<BookResponse> updateBookAvailability(
            @PathVariable Long id,
            @RequestParam Boolean available) {

        Book updatedBook = updateBookUseCase.updateAvailabilityById(id, available);
        return ResponseEntity.ok(mapper.toResponse(updatedBook));
    }


}
