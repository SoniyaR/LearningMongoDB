package com.mongodbdemo.notesapp.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode
@Document("note-data")
public class Note {

    @Id
    private BigInteger id;

    private String title;
    private String noteString;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
