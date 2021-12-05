package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.IAdminService;
import com.miro.dibt.business.tools.Messagess;
import com.miro.dibt.core.utilities.DataResult;
import com.miro.dibt.core.utilities.IResult;
import com.miro.dibt.core.utilities.SuccesDataResult;
import com.miro.dibt.core.utilities.SuccessResult;
import com.miro.dibt.dataAccess.abstracts.IAdminDao;
import com.miro.dibt.entities.concretes.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminManager implements IAdminService {
    private final IAdminDao adminDao;


    @Override
    public DataResult<List<Admin>> getAll() {
        return new SuccesDataResult(adminDao.findAll(), Messagess.adminListed);
    }

    @Override
    public IResult add(Admin admin) {
        adminDao.save(admin);
        return new SuccessResult(Messagess.adminSaved);
    }

    @Override
    public IResult update(Admin admin) {
        adminDao.save(admin);
        return new SuccessResult(Messagess.adminUpdate);
    }

    @Override
    public IResult delete(Admin admin) {
        adminDao.delete(admin);
        return new SuccessResult(Messagess.adminDelete);
    }
}
