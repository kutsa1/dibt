package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.INeihgbourhoodService;
import com.miro.dibt.business.tools.Messagess;
import com.miro.dibt.core.utilities.DataResult;
import com.miro.dibt.core.utilities.IResult;
import com.miro.dibt.core.utilities.SuccesDataResult;
import com.miro.dibt.core.utilities.SuccessResult;
import com.miro.dibt.dataAccess.abstracts.INeighbourhoodDao;
import com.miro.dibt.entities.concretes.Neighbourhood;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NeighbourhoodManager implements INeihgbourhoodService {
    private final INeighbourhoodDao iNeighbourhoodDao;

    @Override
    public DataResult<List<Neighbourhood>> getAll() {

        return new SuccesDataResult(iNeighbourhoodDao.findAll() ,Messagess.neighbourhoodListed);
    }

    @Override
    public IResult add(Neighbourhood neighbourhood) {
        iNeighbourhoodDao.save(neighbourhood);
        return new SuccessResult(Messagess.neighbourhoodSave);
    }

    @Override
    public IResult update(Neighbourhood neighbourhood) {
        iNeighbourhoodDao.save(neighbourhood);
        return new SuccessResult(Messagess.neighbourhoodUpdate);

    }

    @Override
    public IResult delete(Neighbourhood neighbourhood) {
        iNeighbourhoodDao.delete(neighbourhood);
        return new SuccessResult(Messagess.neighbourhoodDelete);
    }
}
