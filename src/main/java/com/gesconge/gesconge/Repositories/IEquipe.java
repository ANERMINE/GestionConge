package com.gesconge.gesconge.Repositories;

import com.gesconge.gesconge.Entities.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEquipe extends JpaRepository<Equipe, Long> {
    @Query("Select e From Equipe e where e.codeEquipe= :codeEquipe")
    public Equipe findEquipeByCode(@Param("codeEquipe") String codeEquipe);
}
