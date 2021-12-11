package com.miro.dibt.entities.concretes;

import com.miro.dibt.core.entities.IEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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


    private String name;


    private int plateCode;

    @OneToMany(fetch = FetchType.EAGER)
    private List<District> districts;

}
