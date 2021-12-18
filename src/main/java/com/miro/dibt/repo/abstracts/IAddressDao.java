package com.miro.dibt.repo.abstracts;

import com.miro.dibt.entities.concretes.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAddressDao extends JpaRepository<Address, Integer> {
    List<Address> findByCityName(String cityName);
    List<Address> findByDistrictName(String districtName);
    List<Address> findByNeighbourhoodName(String neighbourhoodName);

}
