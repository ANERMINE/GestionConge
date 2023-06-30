package com.gesconge.gesconge.Repositories;

import com.gesconge.gesconge.Entities.Employee;
import com.gesconge.gesconge.Entities.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEvenement extends JpaRepository<Evenement,Long> {
    @Query(value="select libelle from evenement where equipe_id_equipe=?",nativeQuery=true)
    String GetEvenementByEquipe(@Param("idEquipe") long idEquipe);
}
