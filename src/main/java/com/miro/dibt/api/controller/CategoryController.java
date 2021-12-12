package com.miro.dibt.api.controller;

import com.miro.dibt.business.abstracts.ICategoryService;
import com.miro.dibt.core.api.ControllerBase;
import com.miro.dibt.entities.concretes.Category;
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
}
