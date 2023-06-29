package com.gesconge.gesconge.Repositories;

import com.gesconge.gesconge.Entities.Employee;
import com.gesconge.gesconge.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IRole extends JpaRepository<Role,Long> {

    @Query(value="select id_role from role where libelle like libelle",nativeQuery=true)
    long GetIdRole(@Param("libelle") String libelle);
}
