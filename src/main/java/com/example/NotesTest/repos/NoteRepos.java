package com.example.NotesTest.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.NotesTest.domain.Note;

import java.util.List;

public interface NoteRepos extends CrudRepository<Note, Integer>{

    List<Note> findByText(String text);
}
