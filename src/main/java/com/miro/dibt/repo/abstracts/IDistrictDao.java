package com.miro.dibt.repo.abstracts;

import com.miro.dibt.entities.concretes.District;
import org.springframework.data.geo.Distance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDistrictDao extends JpaRepository<District,Integer> {
  List<District> findByName(String districtName);

}
