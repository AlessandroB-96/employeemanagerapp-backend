package com.example.demo.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Employee implements Serializable {
    @Id
    //Need to use the value IDENTITY to generation type for MySQL to have an index that increments its value automatically
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String team;
    private String imageUrl;

    //empty constructor
    Employee() {
    }

    //constructor with all fields except id, that is an autogenerated value
    public Employee(String name, String surname, String email, String team, String imageUrl) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.team = team;
        this.imageUrl = imageUrl;
    }

    //Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getImageUrl() { return imageUrl; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

}
