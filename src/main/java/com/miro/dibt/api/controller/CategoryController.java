package com.miro.dibt.api.controller;

import com.miro.dibt.business.abstracts.ICategoryService;
import com.miro.dibt.core.api.ControllerBase;
import com.miro.dibt.core.utilities.results.ErrorResult;
import com.miro.dibt.entities.concretes.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/categories")
public class CategoryController extends ControllerBase<Category, ICategoryService> {

    ICategoryService iCategoryService;

    public CategoryController(ICategoryService iCategoryService) {
        super(iCategoryService);
        this.iCategoryService = iCategoryService;
    }

    @GetMapping("/getallbyasc")
    ResponseEntity<?> getAllByAsc() {
        var result = iCategoryService.getAllByCategoryAsc();
        if (result.isSuccess())
            return new ResponseEntity(result, HttpStatus.OK);
        return new ResponseEntity<>(new ErrorResult(result.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getallbydesc")
    ResponseEntity<?> getAllByDesc() {
        var result = iCategoryService.getAllByCategoryDesc();
        if (result.isSuccess())
            return new ResponseEntity(result, HttpStatus.OK);
        return new ResponseEntity<>(new ErrorResult(result.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
