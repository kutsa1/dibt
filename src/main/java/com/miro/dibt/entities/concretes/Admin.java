package com.miro.dibt.entities.concretes;

import com.miro.dibt.core.dataAccess.IEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "admins")
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends User  {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;
}
