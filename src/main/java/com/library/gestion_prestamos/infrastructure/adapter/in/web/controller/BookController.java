package com.library.gestion_prestamos.infrastructure.adapter.in.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;


    @GetMapping("/available")
    public List<BookDTO> getAvailableBooks() {
        return bookService.getAvailableBooks();
    }

    @GetMapping("/borrowed")
    public List<BookDTO> getBorrowedBooks() {
        return bookService.getBorrowedBooks();
    }


    @PutMapping("/{id}/availability")
    public ResponseEntity<BookDTO> updateBookAvailability(
            @PathVariable Long id,
            @RequestParam Boolean available) {

        BookDTO updatedBook = bookService.updateAvailabilityById(id, available);
        return ResponseEntity.ok(updatedBook);
    }


}
