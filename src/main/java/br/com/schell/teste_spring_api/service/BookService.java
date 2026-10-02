package br.com.schell.teste_spring_api.service;

import br.com.schell.teste_spring_api.database.entity.BookEntity;
import br.com.schell.teste_spring_api.dto.BookDto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    private final List<BookEntity> books = new ArrayList<>();

    @PostConstruct
    public void init() {
        books.addAll(List.of(
                BookEntity.builder()
                        .id(UUID.randomUUID())
                        .name("Book 1")
                        .rating(4).build(),
                BookEntity.builder()
                        .id(UUID.randomUUID())
                        .name("Book 2")
                        .rating(3).build(),
                BookEntity.builder()
                        .id(UUID.randomUUID())
                        .name("Book 3")
                        .rating(5).build()
        ));
    }

    public List<BookEntity> listAll() {
        return new ArrayList<>(books);
    }

    public BookEntity findById(UUID id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public BookEntity insertBook(BookDto bookDto) {
        final BookEntity book = BookEntity.builder()
                .id(UUID.randomUUID())
                .name(bookDto.getName())
                .rating(bookDto.getRating())
                .build();

        books.add(book);
        return book;
    }

    public boolean removeBook(UUID id) {
        return books.removeIf(book -> book.getId().equals(id));
    }
}
