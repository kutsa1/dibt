package com.miro.dibt.entities.concretes;

import com.miro.dibt.core.dataAccess.IEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "neighbourhoods")
@NoArgsConstructor
@AllArgsConstructor
public class Neighbourhood implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "neighbourhood_name")
    private String name;

    @ManyToOne()
    @JoinColumn(name = "district_id")
    private District district;


}