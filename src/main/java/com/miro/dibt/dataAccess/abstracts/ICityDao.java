package com.miro.dibt.dataAccess.abstracts;

import com.miro.dibt.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityDao extends JpaRepository<City,Integer > {
}
