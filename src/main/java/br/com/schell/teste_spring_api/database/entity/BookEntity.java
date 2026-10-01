package br.com.schell.teste_spring_api.database.entity;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BookEntity {
    private UUID id;
    private String name;
    private int rating;
    private int releaseYear;
}
