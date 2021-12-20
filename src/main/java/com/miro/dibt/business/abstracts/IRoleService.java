package com.miro.dibt.business.abstracts;

import com.miro.dibt.core.entities.Role;
import com.miro.dibt.core.utilities.business.IServiceBase;
import com.miro.dibt.core.utilities.results.DataResult;
import com.miro.dibt.core.utilities.results.IResult;

public interface IRoleService extends IServiceBase<Role> {
    DataResult<Role> findByName(String roleName);

    IResult existByRoleId(int id);

}
