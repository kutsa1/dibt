package com.miro.dibt.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.miro.dibt.core.entities.IEntity;
import com.miro.dibt.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "reports")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Report implements IEntity {

    @OneToMany(mappedBy = "report")
    @JsonIgnore
    List<ReportLike> reportLikes = new ArrayList<>();
    @OneToMany(mappedBy = "report")
    @JsonIgnore
    private List<Comment> comments = new ArrayList<>();
    @OneToMany(mappedBy = "report")
    @JsonIgnore
    private List<Photo> photos = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotBlank
    private String text;
    private LocalDateTime dateOfReport = LocalDateTime.now();

    @NotNull
    private boolean status = false;


    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private Category category;

    @ManyToOne
    @JsonIgnore
    private User user;

    @ManyToOne
    @JsonIgnore
    private Address address;


}
