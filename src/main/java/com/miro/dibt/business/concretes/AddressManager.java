package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.IAddressService;
import com.miro.dibt.business.tools.Messagess;
import com.miro.dibt.core.utilities.DataResult;
import com.miro.dibt.core.utilities.IResult;
import com.miro.dibt.core.utilities.SuccesDataResult;
import com.miro.dibt.core.utilities.SuccessResult;
import com.miro.dibt.dataAccess.abstracts.IAddressDao;
import com.miro.dibt.entities.concretes.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressManager implements IAddressService {
    private final IAddressDao iAddressDao;

    @Override
    public DataResult<List<Address>> getAll() {
        return new SuccesDataResult(iAddressDao.findAll(), Messagess.addressListed);
    }

    @Override
    public IResult add(Address address) {
        iAddressDao.save(address);
        return new SuccessResult(Messagess.addressSave);
    }

    @Override
    public IResult update(Address address) {
        iAddressDao.save(address);
        return new SuccessResult(Messagess.addressUpdate);
    }

    @Override
    public IResult delete(Address address) {
        iAddressDao.delete(address);
        return new SuccessResult(Messagess.addressDelete);
    }
}
