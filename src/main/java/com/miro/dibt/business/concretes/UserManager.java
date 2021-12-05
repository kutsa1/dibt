package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.IUserService;
import com.miro.dibt.business.tools.Messagess;
import com.miro.dibt.core.utilities.DataResult;
import com.miro.dibt.core.utilities.IResult;
import com.miro.dibt.core.utilities.SuccesDataResult;
import com.miro.dibt.core.utilities.SuccessResult;
import com.miro.dibt.dataAccess.abstracts.IUserDao;
import com.miro.dibt.entities.concretes.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserManager implements IUserService {
    private final IUserDao iUserDao;

    @Override
    public DataResult<List<User>> getAll() {

        return new SuccesDataResult(iUserDao.findAll(), Messagess.userListed);
    }

    @Override
    public IResult add(User user) {
        iUserDao.save(user);
        return new SuccessResult(Messagess.userSave);
    }

    @Override
    public IResult update(User user) {
        iUserDao.save(user);
        return new SuccessResult(Messagess.userUpdate);
    }

    @Override
    public IResult delete(User user) {
        iUserDao.delete(user);
        return new SuccessResult(Messagess.userDelete);
    }
}
