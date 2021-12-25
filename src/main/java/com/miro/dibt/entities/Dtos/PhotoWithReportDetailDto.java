package com.miro.dibt.entities.Dtos;

import com.miro.dibt.core.entities.IDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhotoWithReportDetailDto implements IDto {
    private int reportId;
    private int photoId;
    private String photoUrl;
}
