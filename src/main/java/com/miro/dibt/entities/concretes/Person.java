package com.miro.dibt.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.miro.dibt.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "persons")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Person extends User {


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Report> reports = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CommentLike> commentLikes = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ReportLike> reportLikes = new ArrayList<>();


    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Address address;

    @NotNull
    @NotBlank
    @Size(min = 2)
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 2)
    private String lastName;

    @NotBlank
    @NotNull
    @Column(unique = true)
    @Size(max = 11, min = 11)
    @Pattern(regexp = "^[1-9]{1}[0-9]{9}[02468]{1}$", message = "Please enter valid id")
    private String nationalityId;

    @NotBlank
    @NotNull
    private String gender;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date birthDay;

}
