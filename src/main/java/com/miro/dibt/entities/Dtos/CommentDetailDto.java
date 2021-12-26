package com.miro.dibt.entities.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDetailDto {

    private int id;
    private String personName;
    private String text;
    private int reportId;
    private LocalDateTime dateOfComment;
    private int numberOfLike;

}
