package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.IAddressService;
import com.miro.dibt.business.tools.Messages;
import com.miro.dibt.core.utilities.results.DataResult;
import com.miro.dibt.core.utilities.results.IResult;
import com.miro.dibt.core.utilities.results.SuccesDataResult;
import com.miro.dibt.core.utilities.results.SuccessResult;
import com.miro.dibt.dataAccess.abstracts.IAddressDao;
import com.miro.dibt.entities.concretes.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressManager implements IAddressService {
    private final IAddressDao iAddressDao;

    @Override
    public DataResult<List<Address>> getAll() {
        return new SuccesDataResult(iAddressDao.findAll(), Messages.addressListed);
    }

    @Override
    public IResult add(Address address) {
        iAddressDao.save(address);
        return new SuccessResult(Messages.addressSave);
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
}
