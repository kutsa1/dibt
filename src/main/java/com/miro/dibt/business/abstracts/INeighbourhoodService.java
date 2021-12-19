package com.miro.dibt.business.abstracts;

import com.miro.dibt.core.utilities.business.IServiceBase;
import com.miro.dibt.core.utilities.results.DataResult;
import com.miro.dibt.core.utilities.results.IResult;
import com.miro.dibt.core.utilities.results.SuccessResult;
import com.miro.dibt.entities.concretes.Neighbourhood;

import java.util.List;

public interface INeighbourhoodService extends IServiceBase<Neighbourhood> {

    DataResult<List<Neighbourhood>> findByNeighbourhoodName(String neighbourhoodName);

    IResult existByNeighbourhoodId(int neighbourhoodId);
}
