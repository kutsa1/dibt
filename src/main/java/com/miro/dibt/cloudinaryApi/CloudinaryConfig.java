package com.miro.dibt.cloudinaryApi;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.miro.dibt.adapters.abstracts.ICloudinaryAdapterService;
import com.miro.dibt.adapters.concretes.CloudinaryAdapterManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Value("${cld.access-key}")
    String apiKey;

    @Value("${cld.secret-key}")
    String apiSecretKey;

    @Bean
    public Cloudinary cloudinaryUser() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "d-bt",
                "api_key", apiKey,
                "api_secret", apiSecretKey));
    }

    @Bean
    public ICloudinaryAdapterService iCloudinaryAdapterService() {
        return new CloudinaryAdapterManager(cloudinaryUser());
    }

}
