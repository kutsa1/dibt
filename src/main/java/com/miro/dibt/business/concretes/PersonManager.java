package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.ICommentService;
import com.miro.dibt.business.abstracts.IPersonService;
import com.miro.dibt.business.abstracts.IUserService;
import com.miro.dibt.business.tools.Messages;
import com.miro.dibt.core.utilities.business.BusinessRule;
import com.miro.dibt.core.utilities.results.*;
import com.miro.dibt.entities.concretes.Person;
import com.miro.dibt.repo.abstracts.IPersonDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PersonManager implements IPersonService {
    private final IPersonDao iPersonDao;
    private final PasswordEncoder passwordEncoder;
    private final IUserService userService;
    private final ICommentService iCommentService;

    @Override
    public DataResult<List<Person>> getAll() {
        return new SuccesDataResult<>(iPersonDao.findAll());
    }

    @Override
    public IResult add(Person person) {
        var result = BusinessRule.run(
                ifExistByUsername(person.getUsername()),
                ifExistByEmail(person.getEmail()),
                ifExistByNationalityId(person.getNationalityId())
        );
        if (result != null)
            return result;

        person.setPassword(passwordEncoder.encode(person.getPassword()));
        iPersonDao.save(person);
        return new SuccessResult(Messages.personAdded);

    }

    @Override
    public IResult update(Person person) {
        iPersonDao.save(person);

        return new SuccessResult(Messages.personUpdated);
    }

    @Override
    public IResult delete(Person person) {
        iPersonDao.delete(person);
        return new SuccessResult(Messages.personDeleted);
    }

    @Override
    public DataResult<Person> getById(Integer id) {

        return new SuccesDataResult<>(iPersonDao.getById(id), Messages.personListed);
    }


    private IResult ifExistByUsername(String username) {

        if (iPersonDao.existsByUsername(username))
            return new ErrorResult(Messages.usernameAlreadyInUse);
        return new SuccessResult();
    }

    private IResult ifExistByEmail(String email) {

        if (iPersonDao.existsByEmail(email))
            return new ErrorResult(Messages.emailAlreadyInUse);
        return new SuccessResult();
    }

    private IResult ifExistByNationalityId(String nationalityId) {

        if (iPersonDao.existsByNationalityId(nationalityId))
            return new ErrorResult(Messages.nationalityIdAlreadyInUse);
        return new SuccessResult();
    }


}
