package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Equipe;
import com.gesconge.gesconge.Entities.Evenement;
import com.gesconge.gesconge.Repositories.IEquipe;
import com.gesconge.gesconge.Repositories.IEvenement;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Getter
@Setter
@Service
public class EvenementService implements IEvenementService{
    @Autowired
    private IEvenement Ievent;
    @Autowired
    private IEquipe equiperepo;
    @Override
    public List<Evenement> retrieveAllEvents() {
        return Ievent.findAll();
    }
    @Override
    public Evenement retrieveEvent(Long id) {

        return Ievent.findById(id).get();
    }
    @Override
    public Evenement addEvent(Evenement e) {
        return Ievent.save(e);
    }

    @Override
    public Evenement updateEvent(Evenement e) {
        return Ievent.save(e);
    }
    @Override
    public void deleteEvent(Long id) {
        Ievent.deleteById(id);
    }
    public Evenement addeventtoequipe(Evenement e, Long idequipe) {

        Equipe equipe = equiperepo.findById(idequipe).orElse(null);
        if (equipe == null ) {
            throw new IllegalArgumentException("Equipe inexistante");
        }
        if(e.getEquipe()!= null){
        equipe.setId_Equipe(e.getEquipe().getId_Equipe());
        equipe.setCodeEquipe(e.getEquipe().getCodeEquipe());
        equiperepo.save(equipe);
        }
        // Ajouter l'evenement à l'equipe correspondante
        e.setEquipe(equipe);
        equipe.getListEvenements().add(e);

        // Enregistrer les modifications dans la base de données
        return Ievent.save(e);
    }

    @Override
    public String GetEvenementByEquipe(long idEquipe) {
         return Ievent.GetEvenementByEquipe(idEquipe);

    }
}
