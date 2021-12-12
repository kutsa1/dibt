package com.miro.dibt.repo.abstracts;


import com.miro.dibt.entities.concretes.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMunicipalityDao extends JpaRepository<Municipality, Integer> {


}
