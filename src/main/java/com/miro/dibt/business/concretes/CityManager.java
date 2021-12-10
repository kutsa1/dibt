package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.ICityService;
import com.miro.dibt.business.tools.Messagess;
import com.miro.dibt.core.utilities.results.DataResult;
import com.miro.dibt.core.utilities.results.IResult;
import com.miro.dibt.core.utilities.results.SuccesDataResult;
import com.miro.dibt.core.utilities.results.SuccessResult;
import com.miro.dibt.dataAccess.abstracts.ICityDao;
import com.miro.dibt.entities.concretes.City;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityManager implements ICityService {
private final ICityDao iCityDao;

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccesDataResult(iCityDao.findAll(), Messagess.cityListed);
    }

    @Override
    public IResult add(City city) {
        iCityDao.save(city);
        return new SuccessResult(Messagess.cityAdd);
    }

    @Override
    public IResult update(City city) {
        iCityDao.save(city);
        return new SuccessResult(Messagess.cityUpdate);
    }

    @Override
    public IResult delete(City city) {
        iCityDao.delete(city);
        return new SuccessResult(Messagess.cityDelete);
    }
}
