package com.miro.dibt.dataAccess.abstracts;

import com.miro.dibt.entities.concretes.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmailDao extends JpaRepository<Email,Integer> {
}
