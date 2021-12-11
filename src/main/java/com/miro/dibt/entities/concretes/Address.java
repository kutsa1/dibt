package com.miro.dibt.entities.concretes;

import com.miro.dibt.core.entities.IEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
public class Address implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @NotNull
    private Municipality municipality;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    private City city;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    private District district;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    private Neighbourhood neighbourhood;

    @NotNull
    private String text;

}
