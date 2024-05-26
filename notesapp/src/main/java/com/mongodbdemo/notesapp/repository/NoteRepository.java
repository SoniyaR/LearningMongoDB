package com.mongodbdemo.notesapp.repository;

import com.mongodbdemo.notesapp.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;
import java.util.Set;

public interface NoteRepository extends MongoRepository<Note, BigInteger> {

    Set<Note> findByTitleLike(String title);

    Set<Note> findByNoteStringLike(String note);
}
