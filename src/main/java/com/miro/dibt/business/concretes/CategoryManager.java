package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.ICategoryService;
import com.miro.dibt.business.tools.Messagess;
import com.miro.dibt.core.utilities.DataResult;
import com.miro.dibt.core.utilities.IResult;
import com.miro.dibt.core.utilities.SuccesDataResult;
import com.miro.dibt.core.utilities.SuccessResult;
import com.miro.dibt.dataAccess.abstracts.ICategoryDao;
import com.miro.dibt.entities.concretes.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryManager implements ICategoryService {
    private final ICategoryDao iCategoryDao;

    @Override
    public DataResult<List<Category>> getAll() {
        return new SuccesDataResult(iCategoryDao.findAll(), Messagess.categoryListed);
    }

    @Override
    public IResult add(Category category) {
       iCategoryDao.save(category);
        return new SuccessResult(Messagess.categorySave);
    }

    @Override
    public IResult update(Category category) {
        iCategoryDao.save(category);
        return new SuccessResult(Messagess.categoryUpdate);
    }

    @Override
    public IResult delete(Category category) {
        iCategoryDao.delete(category);
        return new SuccessResult(Messagess.categoryDelete);
    }
}
