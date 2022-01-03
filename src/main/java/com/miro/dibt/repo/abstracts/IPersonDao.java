package com.miro.dibt.repo.abstracts;


import com.miro.dibt.entities.concretes.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonDao extends JpaRepository<Person, Integer> {
    Person findByUsername(String username);

    Person findByUsernameAndPassword(String username, String password);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByNationalityId(String nationalityId);
}
