package com.gesconge.gesconge.Repositories;

import com.gesconge.gesconge.Entities.Employee;
import com.gesconge.gesconge.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRole extends JpaRepository<Role,Long> {
}
