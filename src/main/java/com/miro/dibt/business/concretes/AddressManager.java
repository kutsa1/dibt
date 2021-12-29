package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.IAddressService;
import com.miro.dibt.business.abstracts.ICityService;
import com.miro.dibt.business.abstracts.IDisctrictService;
import com.miro.dibt.business.abstracts.INeighbourhoodService;
import com.miro.dibt.business.tools.Messages;
import com.miro.dibt.core.utilities.business.BusinessRule;
import com.miro.dibt.core.utilities.results.*;
import com.miro.dibt.entities.Dtos.AddressDetailDto;
import com.miro.dibt.entities.concretes.Address;
import com.miro.dibt.repo.abstracts.IAddressDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressManager implements IAddressService {
    private final IAddressDao iAddressDao;
    private final ICityService iCityService;
    private final IDisctrictService iDisctrictService;
    private final INeighbourhoodService iNeighbourhoodService;

    @Override
    public DataResult<List<Address>> getAll() {
        return new SuccesDataResult(iAddressDao.findAll(), Messages.addressListed);
    }

    @Override
    public IResult add(Address address) {
        var result = BusinessRule.run(
                isExistCityByCityId(address.getCity().getId()),
                isExistDistrictByDistrictId(address.getDistrict().getId()),
                isExistNeighbourhoodByNeighbourhoodId(address.getNeighbourhood().getId())

        );

        if (result != null)
            return result;

        iAddressDao.save(address);
        return new SuccessResult(Messages.addressSave);
    }

    private IResult isExistNeighbourhoodByNeighbourhoodId(int neighbourhoodId) {
        var result = iNeighbourhoodService.existByNeighbourhoodId(neighbourhoodId);
        if (!result.isSuccess())
            return new ErrorResult(Messages.neighbourhoodNotFound);
        return new SuccessResult();

    }

    private IResult isExistDistrictByDistrictId(int districtId) {
        var result = iDisctrictService.existByDistrictId(districtId);
        if (!result.isSuccess())
            return new ErrorResult(Messages.districtNotFound);
        return new SuccessResult();
    }

    private IResult isExistCityByCityId(int cityId) {
        var result = iCityService.existByCityId(cityId);
        if (!result.isSuccess())
            return new ErrorResult(Messages.cityNotFound);
        return new SuccessResult();
    }

    @Override
    public IResult update(Address address) {
        iAddressDao.save(address);
        return new SuccessResult(Messages.addressUpdate);
    }

    @Override
    public IResult delete(Address address) {
        iAddressDao.delete(address);
        return new SuccessResult(Messages.addressDelete);
    }

    @Override
    public DataResult<Address> getById(Integer id) {
        return new SuccesDataResult<>(iAddressDao.getById(id), Messages.addressListed);
    }

    @Override
    public DataResult<List<Address>> findByCityName(String cityName) {
        var result = BusinessRule.run(isExistCityByCityName(cityName));

        if (result != null)
            return new ErrorDataResult<>(result.getMessage());

        return new SuccesDataResult<>(iAddressDao.findByCityName(cityName), Messages.addressListed);
    }


    @Override
    public DataResult<List<Address>> findByDistrictName(String districtName) {
        var result = BusinessRule.run(isExistByDistirctName(districtName));
        if (result != null)
            return new ErrorDataResult(result.getMessage());
        return new SuccesDataResult<>(iAddressDao.findByDistrictName(districtName));

    }


    @Override
    public DataResult<List<Address>> findByNeighbourhoodName(String neighbourhoodName) {
        var result = BusinessRule.run(isExistByNeighbourhoodName(neighbourhoodName));
        return null;
    }

    @Override
    public DataResult<List<AddressDetailDto>> getAllAddressDetailDto() {

        var result = iAddressDao.getAllAddressDetailDto();
        if (result != null)
            return new SuccesDataResult<>(result, Messages.addressListed);
        return new ErrorDataResult<>();
    }

    private IResult isExistByNeighbourhoodName(String neighbourhoodName) {
        var result = iNeighbourhoodService.findByNeighbourhoodName(neighbourhoodName);
        if (result.getData() == null)
            return new ErrorResult(Messages.notFoundByNeighbourhoodName);
        return new SuccessResult();
    }


    private IResult isExistCityByCityName(String cityName) {
        var result = iCityService.findByName(cityName);
        if (result.getData() == null)
            return new ErrorResult(Messages.cityNotFound);
        return new SuccessResult();
    }

    private IResult isExistByDistirctName(String districtName) {
        var result = iDisctrictService.findByName(districtName);
        if (result.getData() == null)
            return new ErrorResult(Messages.notFoundByDistrictName);
        return new SuccessResult();

    }

}
