package com.gesconge.gesconge.Repositories;

import com.gesconge.gesconge.Entities.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface IEquipe extends JpaRepository<Equipe, Long> {
    @Query(value="select id_equipe from equipe where code_equipe like libelle",nativeQuery=true)
    long GetIdEquipe(@Param("libelle") String libelle);
}
