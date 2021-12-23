package com.miro.dibt.entities.Dtos;

import com.miro.dibt.core.entities.IDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDetailDto implements IDto {
    private int id;
    private String text;
    private String personName;
    private String categoryName;
    private LocalDateTime dateOfReport;
    private int numberOfLike;


}
