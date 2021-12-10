package com.miro.dibt.dataAccess.abstracts;

import com.miro.dibt.core.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleDao extends JpaRepository<Role, Integer> {
    boolean existsByName(String roleName);

    Role findByName(String roleName);
}
