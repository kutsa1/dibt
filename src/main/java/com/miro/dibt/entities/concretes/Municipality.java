package com.miro.dibt.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.miro.dibt.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "municipalities")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Municipality extends User {


    @NotNull
    @NotBlank
    private String corporateName;

    @ManyToOne
    @JsonIgnore
    private City city;

    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private Address address;


}
