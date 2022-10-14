package com.bridgelabz.greetingsapp.model;

import javax.persistence.*;


@Entity

public class Greeting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;
    private String name;
    private String message;

    public Greeting() {
    }

    public Greeting(long id, String name, String message) {
        this.id = id;
        this.name = name;
        this.message = message;
    }

    public Greeting(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}