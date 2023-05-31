package com.gesconge.gesconge.Repositories;

import com.gesconge.gesconge.Entities.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReclamation extends JpaRepository<Reclamation,Long> {
}
