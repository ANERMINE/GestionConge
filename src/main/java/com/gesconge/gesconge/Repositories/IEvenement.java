package com.gesconge.gesconge.Repositories;

import com.gesconge.gesconge.Entities.Employee;
import com.gesconge.gesconge.Entities.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEvenement extends JpaRepository<Evenement,Long> {
}
