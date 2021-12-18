package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.IDisctrictService;
import com.miro.dibt.business.tools.Messages;
import com.miro.dibt.core.utilities.results.DataResult;
import com.miro.dibt.core.utilities.results.IResult;
import com.miro.dibt.core.utilities.results.SuccesDataResult;
import com.miro.dibt.core.utilities.results.SuccessResult;
import com.miro.dibt.repo.abstracts.IDistrictDao;
import com.miro.dibt.entities.concretes.District;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DistrictManager implements IDisctrictService {
    private final IDistrictDao iDistrictDao;

    @Override
    public DataResult<List<District>> getAll() {
        return new SuccesDataResult(iDistrictDao.findAll(), Messages.districtListed);
    }

    @Override
    public IResult add(District district) {
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
    public DataResult<List<District>> findByName(String districtName) {
        return new SuccesDataResult<>(iDistrictDao.findByName(districtName));
    }
}
