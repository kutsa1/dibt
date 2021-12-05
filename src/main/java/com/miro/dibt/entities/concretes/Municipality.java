package com.miro.dibt.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.miro.dibt.core.dataAccess.IEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "municipalities")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Municipality extends User  {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "corporate_name")
    private String corporateName;

    @OneToOne(mappedBy = "municipality")
    private District district;


}
