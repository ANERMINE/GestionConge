package Services;

import com.gesconge.gesconge.Entities.Evenement;
import com.gesconge.gesconge.Repositories.IEvenement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvenementService implements IEvenementService{
    @Autowired
    private IEvenement Ievent;
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
    public void deleteEvent(Long id) {
        Ievent.deleteById(id);
    }
}
