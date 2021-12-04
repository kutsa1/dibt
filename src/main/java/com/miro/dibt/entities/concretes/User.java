package com.miro.dibt.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @NotNull
    @NotBlank(message = "please fill full username")
    @Column(name = "username")
    private String username;

    @Email
    @NotBlank(message = "please enter a valid email")
    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @NotBlank(message = "please enter a valid password ")
    @Column(name = "password")
    private String password;

    @NotNull
    @NotBlank(message = "please fill full phone number")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "status")
    private boolean status;

    // passwordhash nasıl yapabilirim tam bilmiyorum
}
