package com.miro.dibt.dataAccess.abstracts;

import com.miro.dibt.entities.concretes.Neighbourhood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INeighbourhoodDao extends JpaRepository<Neighbourhood, Integer> {

}
