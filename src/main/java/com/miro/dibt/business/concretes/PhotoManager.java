package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.IPhotoService;
import com.miro.dibt.business.tools.Messagess;
import com.miro.dibt.core.utilities.DataResult;
import com.miro.dibt.core.utilities.IResult;
import com.miro.dibt.core.utilities.SuccesDataResult;
import com.miro.dibt.core.utilities.SuccessResult;
import com.miro.dibt.dataAccess.abstracts.IPhotoDao;
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
        return new SuccesDataResult(iPhotoDao.findAll(), Messagess.photoListed);
    }

    @Override
    public IResult add(Photo photo) {
        iPhotoDao.save(photo);
        return new SuccessResult(Messagess.photoSaved);
    }

    @Override
    public IResult update(Photo photo) {
        iPhotoDao.save(photo);
        return new SuccessResult(Messagess.photoUpdated);
    }

    @Override
    public IResult delete(Photo photo) {
        iPhotoDao.delete(photo);
        return new SuccessResult(Messagess.photoDeleted);
    }
}