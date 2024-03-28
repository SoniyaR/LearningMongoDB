package com.mongodbdemo.notesapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Builder(toBuilder = true)
@Document("note-data")
public class Note {

    @Id
    private UUID id;

    private String title;
    private String noteString;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
