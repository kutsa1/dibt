package com.miro.dibt.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "mails")
@AllArgsConstructor
@NoArgsConstructor
public class Email {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "content")
    private String content;

    @Column(name = "from_who")
    private String fromWho;

    @Column(name = "to_who")
    private String toWho;

    @Column(name = "date")
    private Date date;
}
