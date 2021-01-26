package com.lukeProject.SpringSecurityWithJPA.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    
    @Id
    private int id;

    private String userName;

    private String email;

    private String password;

    private String role;

    private boolean active;

}
