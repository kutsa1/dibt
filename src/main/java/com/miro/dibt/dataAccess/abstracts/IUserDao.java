package com.miro.dibt.dataAccess.abstracts;

import com.miro.dibt.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User, Integer> {
// İso burası sana süpriz  MOSSZEBBİ
}
