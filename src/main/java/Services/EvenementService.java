package Services;

import com.gesconge.gesconge.Entities.Evenement;
import com.gesconge.gesconge.Entities.Post;
import com.gesconge.gesconge.Repositories.IEvenement;
import com.gesconge.gesconge.Repositories.PostRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
@Setter
@Getter
@Service
@AllArgsConstructor
public class EvenementService {
    private IEvenement Ievent;
    public List<Evenement> retrieveAllEvents() {
        return Ievent.findAll();
    }
    public Evenement retrieveEvent(Long id) {

        return Ievent.findById(id).get();
    }
    public Evenement addEvent(Evenement e) {
        return Ievent.save(e);
    }
    public Evenement updateEvent(Evenement e) {
        return Ievent.save(e);
    }
    public void deleteEvent(Long id) {
        Ievent.deleteById(id);
    }
}
