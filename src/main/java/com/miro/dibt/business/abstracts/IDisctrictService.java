package com.miro.dibt.business.abstracts;

import com.miro.dibt.core.utilities.business.IServiceBase;
import com.miro.dibt.core.utilities.results.DataResult;
import com.miro.dibt.entities.concretes.District;

import java.util.List;

public interface IDisctrictService extends IServiceBase<District> {

    DataResult<List<District>> findByName(String districtName);
}
