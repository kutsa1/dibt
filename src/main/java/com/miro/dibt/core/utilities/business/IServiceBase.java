package com.miro.dibt.core.utilities.business;

import com.miro.dibt.core.entities.IEntity;
import com.miro.dibt.core.utilities.results.DataResult;
import com.miro.dibt.core.utilities.results.IResult;

import java.util.List;

public interface IServiceBase<T extends IEntity> {
    DataResult<List<T>> getAll();

    IResult add(T t);

    IResult update(T t);

    IResult delete(T t);

    DataResult<T> getById(Integer id);

}
