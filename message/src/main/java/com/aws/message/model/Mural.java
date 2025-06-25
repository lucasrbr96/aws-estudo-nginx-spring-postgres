package com.aws.message.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mural {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String message;

    public Mural() {
    }

    private Mural(int id, String name, String message) {
        this.id = id;
        this.name = name;
        this.message = message;
    }

    private Mural(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public static Mural from(final int id, final String name, final String message){
        return new Mural(id, name, message);
    }

    public static Mural from(final String name, final String message){
        return new Mural(name, message);
    }

    public int getId() {
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
