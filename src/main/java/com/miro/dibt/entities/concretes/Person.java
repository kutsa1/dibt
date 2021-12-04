package com.miro.dibt.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "persons")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Person extends User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    @NotNull
    @NotBlank(message = "please fill full name")
    private String name;

    @NotNull
    @Column(name = "last_name")
    @NotBlank(message = "please fill full surname")
    private String lastName;

    @Column(name = "nationality_id")
    @NotBlank(message = "please fill full nationality id")
    @NotNull
    private String nationalityId;

    @NotBlank(message = "please choose your gender")
    @NotNull
    @Column(name = "gender")
    private String gender;

    @Column(name = "date_of_birthday")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthDay;

    @OneToMany(mappedBy = "user")
    List<Comment> comments;

}
