package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.IRoleService;
import com.miro.dibt.business.tools.Messages;
import com.miro.dibt.core.entities.Role;
import com.miro.dibt.core.utilities.business.BusinessRule;
import com.miro.dibt.core.utilities.results.*;
import com.miro.dibt.repo.abstracts.IRoleDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoleManager implements IRoleService {

    private final IRoleDao roleDao;

    @Override
    public DataResult<Role> findByName(String roleName) {
        var result = roleDao.findByName(roleName);
        if (result == null)
            return new ErrorDataResult<>(Messages.roleNotFound);
        return new SuccesDataResult<>(result);
    }


    @Override
    public DataResult<List<Role>> getAll() {
        return new SuccesDataResult<>(roleDao.findAll());
    }

    @Override
    public IResult add(Role role) {
        var result = BusinessRule.run(ifExistByRoleName(role.getName()));
        if (result != null)
            return result;
        roleDao.save(role);
        return new SuccessResult(Messages.roleAdded);
    }


    @Override
    public IResult update(Role role) {
        roleDao.save(role);
        return new SuccessResult(Messages.roleUpdated);
    }

    @Override
    public IResult delete(Role role) {
        roleDao.delete(role);
        return new SuccessResult(Messages.roleDeleted);
    }

    @Override
    public DataResult<Role> getById(Integer id) {
        return null;
    }

    private IResult ifExistByRoleName(String roleName) {
        if (roleDao.existsByName(roleName))
            return new ErrorResult(Messages.roleNameAlreadyExist);
        return new SuccessResult();
    }
}
