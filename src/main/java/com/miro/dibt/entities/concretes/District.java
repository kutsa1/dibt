package com.miro.dibt.entities.concretes;

import com.miro.dibt.core.entities.IEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @NotNull
    @NotNull
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @NotNull
    private Municipality municipality;

    @OneToMany()
    private List<Neighbourhood> neighbourhoods;
}
