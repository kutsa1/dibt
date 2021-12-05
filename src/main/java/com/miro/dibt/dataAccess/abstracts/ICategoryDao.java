package com.miro.dibt.dataAccess.abstracts;

import com.miro.dibt.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryDao extends JpaRepository<Category, Integer> {
}
