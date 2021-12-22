package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.IDisctrictService;
import com.miro.dibt.business.abstracts.IMunicipalityService;
import com.miro.dibt.business.tools.Messages;
import com.miro.dibt.core.utilities.business.BusinessRule;
import com.miro.dibt.core.utilities.results.*;
import com.miro.dibt.repo.abstracts.IDistrictDao;
import com.miro.dibt.entities.concretes.District;
import com.miro.dibt.repo.abstracts.IMunicipalityDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DistrictManager implements IDisctrictService {
    private final IDistrictDao iDistrictDao;
    private final IMunicipalityService iMunicipalityService;

    @Override
    public DataResult<List<District>> getAll() {
        return new SuccesDataResult(iDistrictDao.findAll(), Messages.districtListed);
    }

    @Override
    public IResult add(District district) {
        var result = BusinessRule.run(
                isExistMunicipalityByMunicipalityId(district.getMunicipality().getId())
        );

        if (result != null)
            return result;

        iDistrictDao.save(district);
        return new SuccessResult(Messages.districtSave);
    }


    @Override
    public IResult update(District district) {
        iDistrictDao.save(district);
        return new SuccessResult(Messages.districtUpdate);
    }

    @Override
    public IResult delete(District district) {
        iDistrictDao.delete(district);
        return new SuccessResult(Messages.districtDelete);
    }

    @Override
    public DataResult<District> getById(Integer id) {

        return new SuccesDataResult<>(iDistrictDao.getById(id), Messages.districtListed);
    }

    @Override
    public DataResult<List<District>> findByName(String districtName) {
        return new SuccesDataResult<>(iDistrictDao.findByName(districtName));
    }

    @Override
    public IResult existByDistrictId(int districtId) {
        if (iDistrictDao.existsById(districtId))
            return new SuccessResult(Messages.districtFound);
        return new ErrorResult(Messages.districtNotFound);
    }

    private IResult isExistMunicipalityByMunicipalityId(int municipalityId) {
        var result = iMunicipalityService.existByMunicipalityId(municipalityId);
        if (!result.isSuccess())
            return new ErrorResult(Messages.municipalityNotFound);
        return new SuccessResult();
    }
}
