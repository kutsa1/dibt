package com.miro.dibt.business.abstracts;

import com.miro.dibt.core.utilities.business.IServiceBase;
import com.miro.dibt.core.utilities.results.IResult;
import com.miro.dibt.entities.concretes.Municipality;

public interface IMunicipalityService extends IServiceBase<Municipality> {

    IResult existByMunicipalityId(int municipalityId);
}
