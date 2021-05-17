package com.example.NotesTest;

//class
import com.example.NotesTest.domain.Note;
import com.example.NotesTest.repos.NoteRepos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

//Controller — контроль запросов от Frontend, их обработка и ответ, так же общение с сервисами.

@Controller
public class GreetingController {



    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }




}
