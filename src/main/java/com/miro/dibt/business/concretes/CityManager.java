package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.ICityService;
import com.miro.dibt.business.tools.Messages;
import com.miro.dibt.core.utilities.business.BusinessRule;
import com.miro.dibt.core.utilities.results.*;
import com.miro.dibt.entities.concretes.City;
import com.miro.dibt.repo.abstracts.ICityDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityManager implements ICityService {
    private final ICityDao iCityDao;

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccesDataResult(iCityDao.findAll(), Messages.cityListed);
    }

    @Override
    public IResult add(City city) {
        var result = BusinessRule.run(
                isCityNameUnique(city.getName()),
                isPlateCodeUnique(city.getPlateCode())
        );
        if (result != null)
            return result;
        iCityDao.save(city);
        return new SuccessResult(Messages.cityAdd);
    }


    @Override
    public IResult update(City city) {
        iCityDao.save(city);
        return new SuccessResult(Messages.cityUpdate);
    }

    @Override
    public IResult delete(City city) {
        iCityDao.delete(city);
        return new SuccessResult(Messages.cityDelete);
    }

    @Override
    public DataResult<City> findByName(String cityName) {
        return new SuccesDataResult<>(iCityDao.findByName(cityName));
    }


    private IResult isCityNameUnique(String cityName) {
        if (iCityDao.existsByName(cityName))
            return new ErrorResult(Messages.cityNameBeUnique);
        return new SuccessResult();

    }

    private IResult isPlateCodeUnique(int plateCode) {
        if (iCityDao.existsByPlateCode(plateCode))
            return new ErrorResult(Messages.plateCodeBeUniqie);
        return new SuccessResult();

    }
}
