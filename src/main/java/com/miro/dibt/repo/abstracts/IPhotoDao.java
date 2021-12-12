package com.miro.dibt.repo.abstracts;

import com.miro.dibt.entities.concretes.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPhotoDao extends JpaRepository<Photo,Integer> {
}
