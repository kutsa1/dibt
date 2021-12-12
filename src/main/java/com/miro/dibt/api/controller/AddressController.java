package com.miro.dibt.api.controller;

import com.miro.dibt.core.api.ControllerBase;
import com.miro.dibt.business.abstracts.IAddressService;
import com.miro.dibt.entities.concretes.Address;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/addresses")
public class AddressController extends ControllerBase<Address, IAddressService> {

    IAddressService iAddressService;

    public AddressController(IAddressService iAddressService) {
        super(iAddressService);
        this.iAddressService = iAddressService;
    }

}
