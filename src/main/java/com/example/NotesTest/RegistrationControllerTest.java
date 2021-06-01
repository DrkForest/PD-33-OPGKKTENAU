package com.example.NotesTest;

import com.example.NotesTest.domain.Role;
import com.example.NotesTest.domain.User;
import com.example.NotesTest.repos.UserRepos;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationControllerTest {
    @MockBean
    private UserRepos userRepos;
    public String registration(){
        return "registration";
    }
    User user;
    Map<String, Object> model;



    @Test
    public String addUser(){
        User userFromDb = null;
        Mockito.when(userRepos.findByUsername(user.getUsername()));

        if(userFromDb != null){
            model.put("message", "User already exists");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        Mockito.when(userRepos.save(user));
        Assert.assertNotNull("add_notes_notNull", userRepos);
        return "redirect:/login";
    }

}