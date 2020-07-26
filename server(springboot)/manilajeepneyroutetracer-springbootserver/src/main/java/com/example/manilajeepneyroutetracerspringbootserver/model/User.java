package com.example.manilajeepneyroutetracerspringbootserver.model;

import javax.persistence.*;

@Entity
@Table(name = "adminaccounts")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long admin_id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public User(){

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
