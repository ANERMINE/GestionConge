package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Equipe;
import com.gesconge.gesconge.Entities.Evenement;
import com.gesconge.gesconge.Entities.Post;

import java.util.List;

public interface IEvenementService {
    List<Evenement> retrieveAllEvents();
    Evenement retrieveEvent(Long id);
    Evenement addEvent(Evenement e);
    Evenement updateEvent(Evenement e);
    void deleteEvent(Long id);
    Evenement addeventtoequipe(Evenement e, Long idequipe);

}
