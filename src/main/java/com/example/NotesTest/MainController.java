package com.example.NotesTest;

//class
import com.example.NotesTest.domain.Note;
import com.example.NotesTest.domain.User;
import com.example.NotesTest.repos.NoteRepos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
@Controller
public class MainController {

    @Autowired
    private NoteRepos noteRepos;


    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Note> notes = noteRepos.findAll();

        model.put("notes", notes);
        return "main";
    }
    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
              @RequestParam String date,
              Map<String, Object> model){
        Note note = new Note(text, date, user);

        noteRepos.save(note);

        // NO !!!
        Iterable<Note> notes = noteRepos.findAll();

        model.put("notes", notes);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        Iterable<Note> notes;
        if(filter != null && !filter.isEmpty()){
            notes = noteRepos.findByText(filter);
        } else {
            notes = noteRepos.findAll();
        }
        /*if(notes == null){
            notes = "";
        }else {

        }*/
        model.put("notes", notes);
        return "main";
    }

}

