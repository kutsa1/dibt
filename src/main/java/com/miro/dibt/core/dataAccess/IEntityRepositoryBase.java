package com.miro.dibt.core.dataAccess;

import com.miro.dibt.core.utilities.DataResult;
import com.miro.dibt.core.utilities.IResult;

import java.util.List;

public interface IEntityRepositoryBase<T extends IEntity> {
    DataResult<List<T>> getAll();
    IResult add(T t);
    IResult update(T t);
    IResult delete (T t);
}
