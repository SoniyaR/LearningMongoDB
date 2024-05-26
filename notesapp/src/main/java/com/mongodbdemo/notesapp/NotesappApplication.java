package com.mongodbdemo.notesapp;

import com.mongodbdemo.notesapp.model.Note;
import com.mongodbdemo.notesapp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = NoteRepository.class)
public class NotesappApplication implements CommandLineRunner {

	@Autowired
	NoteRepository noteRepository;

	public static void main(String[] args) {
		SpringApplication.run(NotesappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("-----creating notes-------");
//		createNotes();

		System.out.println("-----fetch all notes-------");
		showAllNotes();

		System.out.println("-----find notes-------");
		showNoteByText("test");
	}

	void createNotes() {
		noteRepository.save(Note.builder().createdAt(LocalDateTime.now()).modifiedAt(LocalDateTime.now())
				.title("note 1").noteString("this is note 1. test.").build());
		noteRepository.save(Note.builder().createdAt(LocalDateTime.now()).modifiedAt(LocalDateTime.now())
				.title("note 2").noteString("this is note 2.").build());
		noteRepository.save(Note.builder().createdAt(LocalDateTime.now()).modifiedAt(LocalDateTime.now())
				.title("note 3 test").noteString("this is note 3. test.").build());
	}

	void showAllNotes() {
		noteRepository.findAll().forEach(note -> System.out.println(note.toString()));
	}
	void showNoteByText(String searchText) {
		Set<Note> notesFound = noteRepository.findByTitleLike(searchText);

		notesFound.addAll(noteRepository.findByNoteStringLike(searchText));

		notesFound.forEach(note -> System.out.println(note.toString()));
	}
}
