package com.gesconge.gesconge.Repositories;

import com.gesconge.gesconge.Entities.Role;
import com.gesconge.gesconge.Entities.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IRole extends JpaRepository<Role,Long> {
    Optional<Role> findByName(RoleName name);
}

