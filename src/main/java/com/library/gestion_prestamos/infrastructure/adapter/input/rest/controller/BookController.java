package com.library.gestion_prestamos.infrastructure.adapter.input.rest.controller;

import com.library.gestion_prestamos.application.port.input.BookService;
import com.library.gestion_prestamos.infrastructure.adapter.input.rest.dto.BookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;


    @GetMapping("/available")
    public List<BookResponse> getAvailableBooks() {
        // TODO: Map Book to BookResponse
        return List.of(); 
    }

    @GetMapping("/borrowed")
    public List<BookResponse> getBorrowedBooks() {
         // TODO: Map Book to BookResponse
        return List.of();
    }


    @PutMapping("/{id}/availability")
    public ResponseEntity<BookResponse> updateBookAvailability(
            @PathVariable Long id,
            @RequestParam Boolean available) {

        // TODO: Map Book to BookResponse
        return ResponseEntity.ok(null);
    }


}
