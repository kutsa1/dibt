package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.IDisctrictService;
import com.miro.dibt.business.tools.Messagess;
import com.miro.dibt.core.utilities.DataResult;
import com.miro.dibt.core.utilities.IResult;
import com.miro.dibt.core.utilities.SuccesDataResult;
import com.miro.dibt.core.utilities.SuccessResult;
import com.miro.dibt.dataAccess.abstracts.IDistrictDao;
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
        return new SuccesDataResult(iDistrictDao.findAll(), Messagess.districtListed);
    }

    @Override
    public IResult add(District district) {
        iDistrictDao.save(district);
        return new SuccessResult(Messagess.districtSave);
    }

    @Override
    public IResult update(District district) {
        iDistrictDao.save(district);
        return new SuccessResult(Messagess.districtUpdate);
    }

    @Override
    public IResult delete(District district) {
        iDistrictDao.delete(district);
        return new SuccessResult(Messagess.districtDelete);
    }
}
