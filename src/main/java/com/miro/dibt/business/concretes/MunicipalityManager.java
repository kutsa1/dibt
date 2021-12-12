package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.IMunicipalityService;
import com.miro.dibt.business.tools.Messages;
import com.miro.dibt.core.utilities.results.DataResult;
import com.miro.dibt.core.utilities.results.IResult;
import com.miro.dibt.core.utilities.results.SuccesDataResult;
import com.miro.dibt.core.utilities.results.SuccessResult;
import com.miro.dibt.entities.concretes.Municipality;
import com.miro.dibt.repo.abstracts.IMunicipalityDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MunicipalityManager implements IMunicipalityService {

    private final IMunicipalityDao iMunicipalityDao;

    @Override
    public DataResult<List<Municipality>> getAll() {
        return new SuccesDataResult<>(iMunicipalityDao.findAll());
    }

    @Override
    public IResult add(Municipality municipality) {
        iMunicipalityDao.save(municipality);


        return new SuccessResult(Messages.municipalityAdded);

    }

    @Override
    public IResult update(Municipality municipality) {
        return null;
    }

    @Override
    public IResult delete(Municipality municipality) {
        return null;
    }
}
