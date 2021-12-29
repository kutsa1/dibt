package com.miro.dibt.business.concretes;

import com.miro.dibt.adapters.abstracts.ICloudinaryAdapterService;
import com.miro.dibt.business.abstracts.IPhotoService;
import com.miro.dibt.business.tools.Messages;
import com.miro.dibt.core.utilities.business.BusinessRule;
import com.miro.dibt.core.utilities.results.*;
import com.miro.dibt.entities.Dtos.PhotoWithReportDetailDto;
import com.miro.dibt.entities.concretes.Photo;
import com.miro.dibt.repo.abstracts.IPhotoDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
        var result = BusinessRule.run(
                isPhotoNull(image),
                isImageSizeValid(image)
        );

        if (result != null)
            return result;

        Photo photo = new Photo();
        var resultImage = iCloudinaryAdapterService.uploadImage(image);

        if (resultImage.isSuccess()) {
            photo.setImgUrl(resultImage.getData().get("url").toString());
            iPhotoDao.save(photo);
            return new SuccessResult(Messages.photoSaved);

        }
        return new ErrorResult(result.getMessage());
    }

    @Override
    public DataResult<List<PhotoWithReportDetailDto>> getAllPhotoWithReportDetailDto() {
        return new SuccesDataResult<>(iPhotoDao.getAllPhotoWithReportDetailDto());
    }

    private IResult isImageSizeValid(MultipartFile image) {
        if (image.getSize() > 5000000)
            return new ErrorResult(Messages.imageSizeUnValid);
        return new SuccessResult();
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

    @Override
    public DataResult<Photo> getById(Integer id) {
        return null;
    }

    private IResult isPhotoNull(MultipartFile image) {
        if (image == null)
            return new ErrorResult(Messages.imageCanNotBeNull);
        return new SuccessResult();
    }
}
