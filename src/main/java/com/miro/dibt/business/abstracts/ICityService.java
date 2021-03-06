package com.miro.dibt.business.abstracts;

import com.miro.dibt.core.utilities.business.IServiceBase;
import com.miro.dibt.core.utilities.results.DataResult;
import com.miro.dibt.core.utilities.results.IResult;
import com.miro.dibt.entities.concretes.City;

import java.util.List;

public interface ICityService extends IServiceBase<City> {
    DataResult<City> findByName(String cityName);

    IResult existByCityId(int cityId);



}
