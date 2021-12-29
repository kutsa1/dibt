package com.miro.dibt.business.abstracts;

import com.miro.dibt.core.utilities.business.IServiceBase;
import com.miro.dibt.core.entities.User;
import com.miro.dibt.core.utilities.results.DataResult;
import com.miro.dibt.core.utilities.results.IResult;

public interface IUserService extends IServiceBase<User> {
    IResult addRoleToUser(String username, String roleName);

    DataResult<User> getByUsername(String username);

    DataResult<User> getById(Integer id);

    IResult existsById(int userId);
}
