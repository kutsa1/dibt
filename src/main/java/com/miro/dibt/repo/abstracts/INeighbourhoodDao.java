package com.miro.dibt.repo.abstracts;

import com.miro.dibt.entities.concretes.Neighbourhood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface INeighbourhoodDao extends JpaRepository<Neighbourhood, Integer> {

    List<Neighbourhood> findByName(String neighbourhoodName);

}
