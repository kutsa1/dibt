package com.miro.dibt.api.controller;

import com.miro.dibt.business.abstracts.INeighbourhoodService;
import com.miro.dibt.core.api.ControllerBase;
import com.miro.dibt.entities.concretes.Neighbourhood;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/neighbourhoods")
public class NeighbourhoodController extends ControllerBase<Neighbourhood, INeighbourhoodService> {

    INeighbourhoodService iNeihgbourhoodService;

    public NeighbourhoodController(INeighbourhoodService iNeihgbourhoodService) {
        super(iNeihgbourhoodService);
        this.iNeihgbourhoodService = iNeihgbourhoodService;
    }
}
