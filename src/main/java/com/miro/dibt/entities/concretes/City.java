package com.miro.dibt.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.miro.dibt.core.entities.IEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name = "cities")
@AllArgsConstructor
@NoArgsConstructor
public class City implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank
    @NotNull
    private String name;

    @NotNull
    private int plateCode;

    @OneToMany()
    @JsonIgnore
    private List<District> districts;

    @OneToMany()
    @JsonIgnore
    private List<Municipality> municipalities;

}
