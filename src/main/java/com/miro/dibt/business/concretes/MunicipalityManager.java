package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.IMunicipalityService;
import com.miro.dibt.core.utilities.results.DataResult;
import com.miro.dibt.core.utilities.results.IResult;
import com.miro.dibt.entities.concretes.Municipality;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MunicipalityManager implements IMunicipalityService {
    @Override
    public DataResult<List<Municipality>> getAll() {
        return null;
    }

    @Override
    public IResult add(Municipality municipality) {
        return null;
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
