package com.miro.dibt.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.miro.dibt.core.dataAccess.IEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "reports")
@AllArgsConstructor
@NoArgsConstructor
public class Report implements IEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "text")
    private String text;

    @Column(name = "date_of_report")
    @DateTimeFormat(pattern = "yyyy.MM.dd G 'at' HH:mm:ss z")
    private Date dateOfReport;

    @Column(name = "number_of_like")
    private int numberOfLike;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany
    private List<Comment> comments;

}
