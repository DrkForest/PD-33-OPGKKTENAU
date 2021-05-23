package com.example.NotesTest;

//class

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

//Controller — контроль запросов от Frontend, их обработка и ответ, так же общение с сервисами.

@Controller
public class GreetingController {



    @GetMapping("/")
    public String greeting(Map<String, Model> model) {

        return "greeting";
    }




}
