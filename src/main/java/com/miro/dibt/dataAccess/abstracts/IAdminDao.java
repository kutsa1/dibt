package com.miro.dibt.dataAccess.abstracts;

import com.miro.dibt.entities.concretes.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminDao extends JpaRepository<Admin, Integer> {


}
