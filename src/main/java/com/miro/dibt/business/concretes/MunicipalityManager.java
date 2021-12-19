package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.IMunicipalityService;
import com.miro.dibt.business.tools.Messages;
import com.miro.dibt.core.utilities.results.*;
import com.miro.dibt.entities.concretes.Municipality;
import com.miro.dibt.repo.abstracts.IMunicipalityDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
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

    @Override
    public DataResult<Municipality> getById(Integer id) {
        return null;
    }

    @Override
    public IResult existByMunicipalityId(int municipalityId) {
        if (iMunicipalityDao.existsById(municipalityId))
        return new SuccessResult(Messages.municipalityFound);
        return new ErrorResult(Messages.municipalityNotFound);
    }
}
