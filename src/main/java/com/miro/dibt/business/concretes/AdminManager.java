package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.IAdminService;
import com.miro.dibt.core.utilities.DataResult;
import com.miro.dibt.core.utilities.IResult;
import com.miro.dibt.dataAccess.abstracts.IAdminDao;
import com.miro.dibt.entities.concretes.Admin;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminManager implements IAdminService {
    private final IAdminDao adminDao;


    @Override
    public DataResult<List<Admin>> getAll() {
        return null;
    }

    @Override
    public IResult add(Admin admin) {
        return null;
    }

    @Override
    public IResult update(Admin admin) {
        return null;
    }

    @Override
    public IResult delete(Admin admin) {
        return null;
    }
}
