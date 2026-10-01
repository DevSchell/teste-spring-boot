package br.com.schell.teste_spring_api.controller;

import br.com.schell.teste_spring_api.database.entity.BookEntity;
import br.com.schell.teste_spring_api.dto.BookDto;
import br.com.schell.teste_spring_api.service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/book")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/list")
    public ResponseEntity<List<BookEntity>> listAllBooks() {
        bookService.listAll();
        return ResponseEntity.ok().body(bookService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookEntity> findById(@PathVariable UUID id) {
        final BookEntity book = bookService.findById(id);

        if (book != null) {
            return ResponseEntity.ok().body(book);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<BookEntity> insertBook(@RequestBody @Valid BookDto bookDto) {
        BookEntity savedBook = bookService.insertBook(bookDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }
}
