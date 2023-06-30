package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Employee;
import com.gesconge.gesconge.Entities.Equipe;
import com.gesconge.gesconge.Entities.Evenement;
import com.gesconge.gesconge.Entities.Score;
import com.gesconge.gesconge.Repositories.IEmployee;
import com.gesconge.gesconge.Repositories.IEquipe;
import com.gesconge.gesconge.Repositories.IEvenement;
import com.gesconge.gesconge.Repositories.IScore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class ScoreService implements IScoreService{

    private IScore Iscore;
    //private IEmployee employerepo;
    @Override
    public List<Score> retrieveAllScores() {
        return Iscore.findAll();
    }
    @Override
    public Score retrieveScore(Long id) {

        return Iscore.findById(id).get();
    }
    @Override
    public Score updateScore(Score s) {
        return Iscore.save(s);
    }
    @Override
    public void deleteScore(Long id) {
        Iscore.deleteById(id);
    }
    /*public Score addscoretoemploye(Score s, Long idemploye) {

        Employee employee = employerepo.findById(idemploye).orElse(null);
        if (employee == null ) {
            throw new IllegalArgumentException("Employe inexistante");
        }
        if(s.getSalarie()!= null){
            employee.setId_Emp(s.getSalarie().getId_Emp());
            employee.setScore(s.getSalarie().getScore());
            employee.sav
        }
        // Ajouter l'evenement à l'equipe correspondante
        e.setEquipe(equipe);
        equipe.getListEvenements().add(e);

        // Enregistrer les modifications dans la base de données
        return Ievent.save(e);
    }*/

}
