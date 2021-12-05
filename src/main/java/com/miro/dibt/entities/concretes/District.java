package com.miro.dibt.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "districts")
@NoArgsConstructor
@AllArgsConstructor

public class District {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;


    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToOne
    @JoinColumn(name = "municipality_id")
    private Municipality municipality;

    @OneToMany
    private List<Neighbourhood> neighbourhoods;
}
