package com.miro.dibt.dataAccess.abstracts;


import com.miro.dibt.entities.concretes.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonDao extends JpaRepository<Person, Integer> {
    Person findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByNationalityId(String nationalityId);
}
