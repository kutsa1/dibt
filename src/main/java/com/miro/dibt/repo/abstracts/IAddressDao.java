package com.miro.dibt.repo.abstracts;

import com.miro.dibt.entities.Dtos.AddressDetailDto;
import com.miro.dibt.entities.concretes.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAddressDao extends JpaRepository<Address, Integer> {
    List<Address> findByCityName(String cityName);

    List<Address> findByDistrictName(String districtName);

    List<Address> findByNeighbourhoodName(String neighbourhoodName);


    @Query("select new com.miro.dibt.entities.Dtos.AddressDetailDto(a.id,u.id,a.text,c.name,d.name,n.name) from Address a join a.user u join a.city c join a.district d join a.neighbourhood n")
    List<AddressDetailDto> getAllAddressDetailDto();


}
