package com.gesconge.gesconge.Repositories;

import com.gesconge.gesconge.Entities.Employee;
import com.gesconge.gesconge.Entities.Justificatif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJustificatif extends JpaRepository<Justificatif,Integer> {
}
