package com.gesconge.gesconge.Repositories;

import com.gesconge.gesconge.Entities.Conge;
import com.gesconge.gesconge.Entities.Pointage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPointage extends JpaRepository<Pointage,Long> {
}
