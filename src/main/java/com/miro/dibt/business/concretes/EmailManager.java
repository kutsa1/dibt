package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.IEmailService;
import com.miro.dibt.business.tools.Messagess;
import com.miro.dibt.core.utilities.DataResult;
import com.miro.dibt.core.utilities.IResult;
import com.miro.dibt.core.utilities.SuccesDataResult;
import com.miro.dibt.core.utilities.SuccessResult;
import com.miro.dibt.dataAccess.abstracts.IEmailDao;
import com.miro.dibt.entities.concretes.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailManager implements IEmailService {
    private final IEmailDao iEmailDao;

    @Override
    public DataResult<List<Email>> getAll() {
        return new SuccesDataResult(iEmailDao.findAll(), Messagess.emailListed);
    }

    @Override
    public IResult add(Email email) {
        iEmailDao.save(email);
        return new SuccessResult(Messagess.emailSaved);
    }

    @Override
    public IResult update(Email email) {
        iEmailDao.save(email);
        return new SuccessResult(Messagess.emailUpdate);
    }

    @Override
    public IResult delete(Email email) {
        iEmailDao.delete(email);
        return new SuccessResult(Messagess.emailDeleted);
    }
}
