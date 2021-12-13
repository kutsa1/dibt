package com.miro.dibt.business.abstracts;

import com.miro.dibt.core.utilities.business.IServiceBase;
import com.miro.dibt.core.utilities.results.DataResult;
import com.miro.dibt.entities.concretes.City;

public interface ICityService extends IServiceBase<City> {
    DataResult<City> findByName(String cityName);
}
