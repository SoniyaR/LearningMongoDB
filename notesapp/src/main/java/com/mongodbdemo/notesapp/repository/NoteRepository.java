package com.mongodbdemo.notesapp.repository;

import com.mongodbdemo.notesapp.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface NoteRepository extends MongoRepository<Note, UUID> {

    Optional<Note> findByTitleLike(String title);

    Optional<Note> findByNoteStringLike(String note);
}
