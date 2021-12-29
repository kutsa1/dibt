package com.miro.dibt.api.controller;

import com.miro.dibt.business.abstracts.IAddressService;
import com.miro.dibt.core.api.ControllerBase;
import com.miro.dibt.core.utilities.results.ErrorResult;
import com.miro.dibt.entities.concretes.Address;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/addresses")
public class AddressController extends ControllerBase<Address, IAddressService> {

    IAddressService iAddressService;


    public AddressController(IAddressService iAddressService) {
        super(iAddressService);
        this.iAddressService = iAddressService;
    }


    @GetMapping("/getbycityname")
    ResponseEntity<?> getByCityName(@RequestParam String cityName) {
        var result = iAddressService.findByCityName(cityName);
        if (result.isSuccess())
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(new ErrorResult(result.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getbydistrictname")
    ResponseEntity<?> getByDistrictName(@RequestParam String districtName) {
        var result = iAddressService.findByDistrictName(districtName);
        if (result.isSuccess())
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(new ErrorResult(result.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getbyneighbourhoodname")
    ResponseEntity<?> getByNeighbourhoodName(@RequestParam String neighbourhoodName) {
        var result = iAddressService.findByNeighbourhoodName(neighbourhoodName);
        if (result.isSuccess())
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(new ErrorResult(result.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getalladdressdetaildto")
    ResponseEntity<?> getAllAddressDetailDto() {
        var result = iAddressService.getAllAddressDetailDto();
        if (result.isSuccess())
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(new ErrorResult(result.getMessage()), HttpStatus.BAD_REQUEST);
    }


}
