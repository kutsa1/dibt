package com.miro.dibt.entities.concretes;

import com.miro.dibt.core.entities.IEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Table(name = "comments")
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotBlank
    @NotNull
    private String text;

    @NotNull
    @NotBlank
    private Date date;

    @NotNull
    private int numberOfLike;

    @NotNull
    private boolean status;

}
