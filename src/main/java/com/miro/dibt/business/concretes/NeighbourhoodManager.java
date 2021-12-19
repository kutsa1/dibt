package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.INeighbourhoodService;
import com.miro.dibt.business.tools.Messages;
import com.miro.dibt.core.utilities.results.*;
import com.miro.dibt.repo.abstracts.INeighbourhoodDao;
import com.miro.dibt.entities.concretes.Neighbourhood;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NeighbourhoodManager implements INeighbourhoodService {
    private final INeighbourhoodDao iNeighbourhoodDao;

    @Override
    public DataResult<List<Neighbourhood>> getAll() {

        return new SuccesDataResult(iNeighbourhoodDao.findAll(), Messages.neighbourhoodListed);
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

    @Override
    public DataResult<Neighbourhood> getById(Integer id) {
        return null;
    }

    @Override
    public DataResult<List<Neighbourhood>> findByNeighbourhoodName(String neighbourhoodName) {
        return new SuccesDataResult<>(iNeighbourhoodDao.findByName(neighbourhoodName), Messages.neighbourhoodListed);
    }

    @Override
    public IResult existByNeighbourhoodId(int neighbourhoodId) {
        if (iNeighbourhoodDao.existsById(neighbourhoodId))
            return new SuccessResult(Messages.neighbourhoodListed);
        return new ErrorResult(Messages.neighbourhoodNotFound);
    }


}
