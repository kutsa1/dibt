package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.INeihgbourhoodService;
import com.miro.dibt.business.tools.Messages;
import com.miro.dibt.core.utilities.results.DataResult;
import com.miro.dibt.core.utilities.results.IResult;
import com.miro.dibt.core.utilities.results.SuccesDataResult;
import com.miro.dibt.core.utilities.results.SuccessResult;
import com.miro.dibt.repo.abstracts.INeighbourhoodDao;
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

        return new SuccesDataResult(iNeighbourhoodDao.findAll() , Messages.neighbourhoodListed);
    }

    @Override
    public IResult add(Neighbourhood neighbourhood) {
        iNeighbourhoodDao.save(neighbourhood);
        return new SuccessResult(Messages.neighbourhoodSave);
    }

    @Override
    public IResult update(Neighbourhood neighbourhood) {
        iNeighbourhoodDao.save(neighbourhood);
        return new SuccessResult(Messages.neighbourhoodUpdate);

    }

    @Override
    public IResult delete(Neighbourhood neighbourhood) {
        iNeighbourhoodDao.delete(neighbourhood);
        return new SuccessResult(Messages.neighbourhoodDelete);
    }
}
