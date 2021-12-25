package com.miro.dibt.api.controller;

import com.miro.dibt.business.abstracts.IPhotoService;
import com.miro.dibt.core.api.ControllerBase;
import com.miro.dibt.core.utilities.results.ErrorResult;
import com.miro.dibt.entities.concretes.Photo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/photos")
public class PhotoController extends ControllerBase<Photo, IPhotoService> {
    IPhotoService iPhotoService;

    public PhotoController(IPhotoService iPhotoService) {
        super(iPhotoService);
        this.iPhotoService = iPhotoService;
    }

    @PostMapping("/addimage")
    public ResponseEntity<?> addImage(@RequestBody MultipartFile image) {
        var result = iPhotoService.addImage(image);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ErrorResult(result.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getallphotowithreportdetaildto")
    public ResponseEntity<?> getAllPhotoWithReportDetailDto() {
        var result = iPhotoService.getAllPhotoWithReportDetailDto();
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ErrorResult(result.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
