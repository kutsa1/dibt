package com.miro.dibt.business.abstracts;

import com.miro.dibt.core.utilities.business.IServiceBase;
import com.miro.dibt.core.utilities.results.DataResult;
import com.miro.dibt.entities.concretes.Category;

import java.util.List;

public interface ICategoryService extends IServiceBase<Category> {

    DataResult<List<Category>> getAllByCategoryAsc();

    DataResult<List<Category>> getAllByCategoryDesc();


}
