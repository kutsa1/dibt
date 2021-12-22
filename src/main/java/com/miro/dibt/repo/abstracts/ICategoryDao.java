package com.miro.dibt.repo.abstracts;

import com.miro.dibt.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryDao extends JpaRepository<Category, Integer> {
    boolean existsByCategoryName(String categoryName);

    List<Category> findAllByOrderByCategoryNameAsc();

    List<Category> findAllByOrderByCategoryNameDesc();

}
