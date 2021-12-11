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
    private int id;


    private int cityId;

    private int municipalityId;

    private int districtId;

    private int neighbourhoodId;

    private String text;

}
