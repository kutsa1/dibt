package com.miro.dibt.business.concretes;

import com.miro.dibt.adapters.abstracts.ICloudinaryAdapterService;
import com.miro.dibt.business.abstracts.IPhotoService;
import com.miro.dibt.business.tools.Messages;
import com.miro.dibt.core.utilities.results.*;
import com.miro.dibt.repo.abstracts.IPhotoDao;
import com.miro.dibt.entities.concretes.Photo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PhotoManager implements IPhotoService {
    private final IPhotoDao iPhotoDao;
    private final ICloudinaryAdapterService iCloudinaryAdapterService;

    @Override
    public DataResult<List<Photo>> getAll() {
        return new SuccesDataResult(iPhotoDao.findAll(), Messages.photoListed);
    }

    @Override
    public IResult add(Photo photo) {
        return null;
    }

    @Override
    public IResult addImage(MultipartFile image) {
        Photo photo = new Photo();
        var result = iCloudinaryAdapterService.uploadImage(image);
        if (result.isSuccess()) {
            photo.setImgUrl(result.getData().get("url").toString());
            iPhotoDao.save(photo);
            return new SuccessResult(Messages.photoSaved);

        }
        return new ErrorResult(result.getMessage());
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
