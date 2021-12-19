package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.IPersonService;
import com.miro.dibt.business.abstracts.IUserService;
import com.miro.dibt.business.tools.Messages;
import com.miro.dibt.core.utilities.business.BusinessRule;
import com.miro.dibt.core.utilities.results.*;
import com.miro.dibt.repo.abstracts.IPersonDao;
import com.miro.dibt.entities.concretes.Person;
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
    private final IPersonDao personDao;
    private final PasswordEncoder passwordEncoder;
    private final IUserService userService;

    @Override
    public DataResult<List<Person>> getAll() {
        return new SuccesDataResult<>(personDao.findAll());
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
        personDao.save(person);
        return new SuccessResult(Messages.personAdded);

    }

    @Override
    public IResult update(Person person) {
        personDao.save(person);

        return new SuccessResult(Messages.personUpdated);
    }

    @Override
    public IResult delete(Person person) {
        personDao.delete(person);
        return new SuccessResult(Messages.personDeleted);
    }

    @Override
    public DataResult<Person> getById(Integer id) {
        return null;
    }


    private IResult ifExistByUsername(String username) {

        if (personDao.existsByUsername(username))
            return new ErrorResult(Messages.usernameAlreadyInUse);
        return new SuccessResult();
    }

    private IResult ifExistByEmail(String email) {

        if (personDao.existsByEmail(email))
            return new ErrorResult(Messages.emailAlreadyInUse);
        return new SuccessResult();
    }

    private IResult ifExistByNationalityId(String nationalityId) {

        if (personDao.existsByNationalityId(nationalityId))
            return new ErrorResult(Messages.nationalityIdAlreadyInUse);
        return new SuccessResult();
    }


}
