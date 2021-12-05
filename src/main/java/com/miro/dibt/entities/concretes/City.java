package com.miro.dibt.entities.concretes;

import com.miro.dibt.core.dataAccess.IEntity;
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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "plate_code")
    private int plateCode;

    @OneToMany(mappedBy = "city")
    private List<District> districts;

}
