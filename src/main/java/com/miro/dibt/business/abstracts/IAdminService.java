package com.miro.dibt.business.abstracts;

import com.miro.dibt.core.utilities.DataResult;
import com.miro.dibt.core.utilities.Result;
import com.miro.dibt.entities.concretes.Admin;

import java.util.List;

public interface IAdminService {

    DataResult<List<Admin>> getAll();
    Result add(Admin admin);
    Result delete(Admin admin);
    Result update(Admin admin);

}
