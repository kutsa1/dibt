package com.miro.dibt.entities.concretes;

import com.miro.dibt.core.entities.IEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
public class Address implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;


    @Column(name = "city_id")
    private int cityId;

    @Column(name = "municipality_id")
    private int municipalityId;

    @Column(name = "district_id")
    private int districtId;

    @Column(name = "neighbourhood_id")
    private int neighbourhoodId;

    @Column(name = "text_id")
    private String textId;

}
