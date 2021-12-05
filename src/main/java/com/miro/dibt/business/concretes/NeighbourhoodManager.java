package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.INeihgbourhoodService;
import com.miro.dibt.core.utilities.DataResult;
import com.miro.dibt.core.utilities.IResult;
import com.miro.dibt.entities.concretes.Neighbourhood;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NeighbourhoodManager implements INeihgbourhoodService {
    @Override
    public DataResult<List<Neighbourhood>> getAll() {
        return null;
    }

    @Override
    public IResult add(Neighbourhood neighbourhood) {
        return null;
    }

    @Override
    public IResult update(Neighbourhood neighbourhood) {
        return null;
    }

    @Override
    public IResult delete(Neighbourhood neighbourhood) {
        return null;
    }
}
