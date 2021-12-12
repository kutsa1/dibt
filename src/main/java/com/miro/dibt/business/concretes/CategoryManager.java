package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.ICategoryService;
import com.miro.dibt.business.tools.Messages;
import com.miro.dibt.core.utilities.results.DataResult;
import com.miro.dibt.core.utilities.results.IResult;
import com.miro.dibt.core.utilities.results.SuccesDataResult;
import com.miro.dibt.core.utilities.results.SuccessResult;
import com.miro.dibt.repo.abstracts.ICategoryDao;
import com.miro.dibt.entities.concretes.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryManager implements ICategoryService {
    private final ICategoryDao iCategoryDao;

    @Override
    public DataResult<List<Category>> getAll() {
        return new SuccesDataResult(iCategoryDao.findAll(), Messages.categoryListed);
    }

    @Override
    public IResult add(Category category) {
       iCategoryDao.save(category);
        return new SuccessResult(Messages.categorySave);
    }

    @Override
    public IResult update(Category category) {
        iCategoryDao.save(category);
        return new SuccessResult(Messages.categoryUpdate);
    }

    @Override
    public IResult delete(Category category) {
        iCategoryDao.delete(category);
        return new SuccessResult(Messages.categoryDelete);
    }
}
