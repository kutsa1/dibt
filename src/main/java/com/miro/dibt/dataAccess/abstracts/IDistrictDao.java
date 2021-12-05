package com.miro.dibt.dataAccess.abstracts;

import com.miro.dibt.entities.concretes.District;
import org.springframework.data.geo.Distance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDistrictDao extends JpaRepository<District,Integer> {
}
