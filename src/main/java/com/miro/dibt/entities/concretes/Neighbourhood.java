package com.miro.dibt.entities.concretes;

import com.miro.dibt.core.entities.IEntity;
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

    private int id;

    private String name;

    @ManyToOne()
    @JoinColumn(name = "district_id")
    private District district;


}
