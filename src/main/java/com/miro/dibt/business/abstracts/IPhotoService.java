package com.miro.dibt.business.abstracts;

import com.miro.dibt.core.utilities.business.IServiceBase;
import com.miro.dibt.core.utilities.results.IResult;
import com.miro.dibt.entities.concretes.Photo;
import org.springframework.web.multipart.MultipartFile;

public interface IPhotoService extends IServiceBase<Photo> {

    IResult addImage(MultipartFile image);


}
