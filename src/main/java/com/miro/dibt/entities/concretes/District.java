package com.miro.dibt.entities.concretes;

import com.miro.dibt.core.entities.IEntity;
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

public class District implements IEntity {
    @Id

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

    @OneToMany(fetch = FetchType.EAGER)
    private List<Neighbourhood> neighbourhoods;
}
