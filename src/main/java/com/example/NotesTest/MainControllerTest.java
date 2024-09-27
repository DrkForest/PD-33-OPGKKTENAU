package com.example.NotesTest;

import com.example.NotesTest.domain.Note;
import com.example.NotesTest.repos.NoteRepos;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.Map;

class MainControllerTest {

    @MockBean
    private NoteRepos noteRepos;
    Map<String, Object> model;
    String filter;
    String text;
    String date;

    @Test
     public void main_test_notNull() {
        Iterable<Note> notes = this.noteRepos.findAll();
        Mockito.when(noteRepos.findAll()).thenReturn(Collections.emptyList());
        Assert.assertNotNull("main_notes_notNull", notes);
        Mockito.when(this.model.put("notes", notes));
        Assert.assertNotNull("main_model_notNull", this.model);

    }

    @Test
    public void add_test_notNull() {
        Note note = new Note(this.text, this.date);
        Mockito.when(this.noteRepos.save(note));
        Assert.assertNull("add_noteRepos_notNull", this.noteRepos);
        Iterable<Note> notes;
        Mockito.when(notes = this.noteRepos.findAll());
        Assert.assertNotNull("add_notes_notNull", notes);
        Mockito.when(this.model.put("notes", notes));
        Assert.assertNotNull("add_model_notNull", this.model);

    }

    @Test
    void filter_test_notNull() {
        Iterable<Note> notes;

        if (this.filter != null && !this.filter.isEmpty()) {
            Mockito.when(notes = this.noteRepos.findByText(this.filter));
        } else {
            Mockito.when(notes = this.noteRepos.findAll());
        }

        Mockito.when(this.model.put("notes", notes));
        Assert.assertNotNull("filter_model_notNull", this.model);
    }
}