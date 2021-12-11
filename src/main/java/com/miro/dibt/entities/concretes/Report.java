package com.miro.dibt.entities.concretes;

import com.miro.dibt.core.entities.IEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "reports")
@AllArgsConstructor
@NoArgsConstructor
public class Report implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @NotBlank
    private String text;

    @NotNull
    @NotBlank
    private Date dateOfReport;

    @NotNull
    private boolean status;

    @NotNull
    private int numberOfLike;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private Category category;

    @OneToMany
    private List<Comment> comments;

}
