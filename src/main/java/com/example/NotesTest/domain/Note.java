package com.example.NotesTest.domain;

import javax.persistence.*;

@SuppressWarnings("JpaAttributeTypeInspection")
@Entity // This tells Hibernate to make a table out of this class
public class Note {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String text;
    private String date;

    // eager = fast,
    // lazy = slow
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;


    public Note() {

    }

    public Note(String text, String date, User user) {
        this.user = user;
        this.text = text;
        this.date = date;
    }

    public String getUserName(){
        return user != null ? user.getUsername() : "<none>";
    }

    //getter setter
    public User getAuth() {

        return user;
    }

    public void setAuth(User user_id) {

        this.user = user_id;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
