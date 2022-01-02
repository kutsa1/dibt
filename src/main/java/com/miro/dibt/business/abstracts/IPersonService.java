package com.miro.dibt.business.abstracts;

import com.miro.dibt.core.utilities.business.IServiceBase;
import com.miro.dibt.core.utilities.results.DataResult;
import com.miro.dibt.entities.concretes.Person;

public interface IPersonService extends IServiceBase<Person> {
    DataResult<Person> findByUsernameAndPassword(String username, String password);

}