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
@Table(name = "comments")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Comment implements IEntity {


    @ManyToOne
    @JsonIgnore
    Report report;

    @ManyToOne
    @JsonIgnore
    private User user;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @NotNull
    private String text;


    private boolean status = true;
    private LocalDateTime date = LocalDateTime.now();

    @JsonIgnore
    @OneToMany(mappedBy = "comment", fetch = FetchType.LAZY)
    private List<CommentLike> likes = new ArrayList<>();
}
