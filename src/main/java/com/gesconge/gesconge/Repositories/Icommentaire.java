package com.gesconge.gesconge.Repositories;

import com.gesconge.gesconge.Entities.Commentaire;
import com.gesconge.gesconge.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Icommentaire extends JpaRepository<Commentaire,Long> {
}
