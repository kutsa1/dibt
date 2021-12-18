package com.miro.dibt.adapters.abstracts;

import com.miro.dibt.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ICloudinaryAdapterService {
    DataResult<Map> uploadImage(MultipartFile image);
}
