package com.example.apiejemplo.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String email;

    private String password;

    @OneToMany(mappedBy = "user") //Nombre de la propiedad en la otra clase
    private List<Tweet> tweets;

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
