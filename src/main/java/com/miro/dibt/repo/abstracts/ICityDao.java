package com.miro.dibt.repo.abstracts;

import com.miro.dibt.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityDao extends JpaRepository<City, Integer> {
    City findByName(String cityName);

    boolean existsByName(String cityName);

    boolean existsByPlateCode(int plateCode);

}
