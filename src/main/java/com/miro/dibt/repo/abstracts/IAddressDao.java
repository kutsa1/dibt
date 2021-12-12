package com.miro.dibt.repo.abstracts;

import com.miro.dibt.entities.concretes.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IAddressDao extends JpaRepository<Address, Integer> {
}
