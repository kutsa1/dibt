package com.miro.dibt.entities.concretes;

import com.miro.dibt.core.entities.IEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "mails")
@AllArgsConstructor
@NoArgsConstructor
public class Email implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @NotBlank
    private String content;

    @NotNull
    @NotBlank
    private String fromWho;

    @NotNull
    @NotBlank
    private String toWho;

    @NotNull
    @NotBlank
    private Date date;
}
