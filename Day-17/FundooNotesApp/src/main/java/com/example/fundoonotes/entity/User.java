package com.example.fundoonotes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int userId;
    private String firstName;
    private String lastName;
    @Column(unique=true, nullable=false)
    private String email;
    @Column(nullable = false)
    private String passwordHash;

}


