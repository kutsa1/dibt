package com.miro.dibt.repo.abstracts;

import com.miro.dibt.core.entities.User;
import com.miro.dibt.entities.Dtos.UserDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUserDao extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    User findByEmailAndIdNot(String email, int id);

    User findByUsernameAndIdNot(String username, int id);

    @Query("select new com.miro.dibt.entities.Dtos.UserDetailDto(p.id,p.username,p.name,p.lastName) from  Person p where p.username=:username")
    List<UserDetailDto> getUserDetailDto(String username);
}
