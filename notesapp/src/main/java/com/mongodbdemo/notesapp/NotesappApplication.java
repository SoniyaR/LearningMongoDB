package com.mongodbdemo.notesapp;

import com.mongodbdemo.notesapp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class NotesappApplication implements CommandLineRunner {

	@Autowired
	NoteRepository noteRepository;

	public static void main(String[] args) {
		SpringApplication.run(NotesappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
