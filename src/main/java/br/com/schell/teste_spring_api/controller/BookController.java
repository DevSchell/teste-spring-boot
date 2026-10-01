package br.com.schell.teste_spring_api.controller;

import br.com.schell.teste_spring_api.database.entity.BookEntity;
import br.com.schell.teste_spring_api.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
