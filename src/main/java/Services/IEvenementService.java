package Services;

import com.gesconge.gesconge.Entities.Evenement;
import com.gesconge.gesconge.Entities.Post;

import java.util.List;

public interface IEvenementService {
    List<Evenement> retrieveAllEvents();
    Evenement retrieveEvent(Long id);
    Evenement addEvent(Evenement p);
    Evenement updateEvent(Evenement P);
    void deleteEvent(Long id);

}
