package com.gesconge.gesconge.Repositories;

import com.gesconge.gesconge.Entities.Conge;
import com.gesconge.gesconge.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IConge extends JpaRepository<Conge,Long> {


}
