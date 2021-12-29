package com.miro.dibt.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.miro.dibt.core.entities.IEntity;
import com.miro.dibt.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotNull
    @OneToOne()
    @JsonIgnore
    private City city;

    @NotNull
    @OneToOne()
    @JsonIgnore
    private User user;

    @NotNull
    @OneToOne()
    @JsonIgnore
    private District district;

    @NotNull
    @OneToOne()
    @JsonIgnore
    private Neighbourhood neighbourhood;

    @NotNull
    private String text;

    @JsonIgnore
    @OneToMany(mappedBy = "address")
    private List<Report> reports;


}
