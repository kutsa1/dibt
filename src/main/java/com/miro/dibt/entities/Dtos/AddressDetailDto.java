package com.miro.dibt.entities.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDetailDto {
    private int id;
    private int userId;
    private String text;
    private String cityName;
    private String districtName;
    private String neighbourhoodName;
}
