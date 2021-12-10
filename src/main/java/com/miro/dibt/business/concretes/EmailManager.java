package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.IEmailService;
import com.miro.dibt.business.tools.Messages;
import com.miro.dibt.core.utilities.results.DataResult;
import com.miro.dibt.core.utilities.results.IResult;
import com.miro.dibt.core.utilities.results.SuccesDataResult;
import com.miro.dibt.core.utilities.results.SuccessResult;
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
        return new SuccesDataResult(iEmailDao.findAll(), Messages.emailListed);
    }

    @Override
    public IResult add(Email email) {
        iEmailDao.save(email);
        return new SuccessResult(Messages.emailSaved);
    }

    @Override
    public IResult update(Email email) {
        iEmailDao.save(email);
        return new SuccessResult(Messages.emailUpdate);
    }

    @Override
    public IResult delete(Email email) {
        iEmailDao.delete(email);
        return new SuccessResult(Messages.emailDeleted);
    }
}
