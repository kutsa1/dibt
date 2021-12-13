package com.miro.dibt.business.abstracts;

import com.miro.dibt.core.utilities.business.IServiceBase;
import com.miro.dibt.core.utilities.results.DataResult;
import com.miro.dibt.entities.concretes.Address;

import java.util.List;

public interface IAddressService extends IServiceBase<Address> {
    DataResult<List<Address>> findByCityName(String cityName);

    DataResult<List<Address>> findByDistrictName(String districtName);

    DataResult<List<Address>> findByNeighbourhoodName(String neighbourhoodName);

}
