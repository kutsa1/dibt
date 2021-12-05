package com.miro.dibt.dataAccess.abstracts;

import com.miro.dibt.entities.concretes.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressDao extends JpaRepository<Address, Integer> {
}
