package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.IPhotoService;
import com.miro.dibt.business.tools.Messages;
import com.miro.dibt.core.utilities.results.DataResult;
import com.miro.dibt.core.utilities.results.IResult;
import com.miro.dibt.core.utilities.results.SuccesDataResult;
import com.miro.dibt.core.utilities.results.SuccessResult;
import com.miro.dibt.repo.abstracts.IPhotoDao;
import com.miro.dibt.entities.concretes.Photo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoManager implements IPhotoService {
    private final IPhotoDao iPhotoDao;
    @Override
    public DataResult<List<Photo>> getAll() {
        return new SuccesDataResult(iPhotoDao.findAll(), Messages.photoListed);
    }

    @Override
    public IResult add(Photo photo) {
        iPhotoDao.save(photo);
        return new SuccessResult(Messages.photoSaved);
    }

    @Override
    public IResult update(Photo photo) {
        iPhotoDao.save(photo);
        return new SuccessResult(Messages.photoUpdated);
    }

    @Override
    public IResult delete(Photo photo) {
        iPhotoDao.delete(photo);
        return new SuccessResult(Messages.photoDeleted);
    }
}
