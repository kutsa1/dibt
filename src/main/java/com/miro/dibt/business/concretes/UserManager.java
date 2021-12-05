package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.IUserService;
import com.miro.dibt.core.utilities.DataResult;
import com.miro.dibt.core.utilities.IResult;
import com.miro.dibt.entities.concretes.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserManager implements IUserService {
    @Override
    public DataResult<List<User>> getAll() {
        return null;
    }

    @Override
    public IResult add(User user) {
        return null;
    }

    @Override
    public IResult update(User user) {
        return null;
    }

    @Override
    public IResult delete(User user) {
        return null;
    }
}
