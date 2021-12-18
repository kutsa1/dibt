package com.miro.dibt.adapters.concretes;

import com.cloudinary.Cloudinary;
import com.miro.dibt.adapters.abstracts.ICloudinaryAdapterService;
import com.miro.dibt.business.tools.Messages;
import com.miro.dibt.cloudinaryApi.CloudinaryApi;
import com.miro.dibt.core.utilities.results.DataResult;
import com.miro.dibt.core.utilities.results.ErrorDataResult;
import com.miro.dibt.core.utilities.results.SuccesDataResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class CloudinaryAdapterManager implements ICloudinaryAdapterService {

    private final Cloudinary cloudinary;
    private final CloudinaryApi cloudinaryApi;

    public CloudinaryAdapterManager(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
        this.cloudinaryApi = new CloudinaryApi();
    }

    @Override
    public DataResult<Map> uploadImage(MultipartFile image) {
        var result = cloudinaryApi.uploadImage(image, cloudinary);
        if (result != null)
            return new SuccesDataResult<>(result);
        return new ErrorDataResult<>(Messages.imageUploadError);
    }
}
