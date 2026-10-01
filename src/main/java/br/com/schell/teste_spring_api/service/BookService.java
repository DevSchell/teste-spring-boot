package br.com.schell.teste_spring_api.service;

import br.com.schell.teste_spring_api.database.entity.BookEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    private final List<BookEntity> books = List.of(
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
    );

    public List<BookEntity> listAll() {
        return new ArrayList<>(books);
    }

    public BookEntity findById(UUID id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
