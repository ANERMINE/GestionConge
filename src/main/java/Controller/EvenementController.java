package Controller;

import Services.IEvenementService;
import com.gesconge.gesconge.Entities.Evenement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Event")

public class EvenementController {
    @Autowired
    private IEvenementService eventservice;

    @GetMapping("/allEvents")
    @ResponseBody
    public List<Evenement> retrieveAllEvents() {
        return eventservice.retrieveAllEvents();
    }

    @GetMapping("/EventByID/{id-Event}")
    @ResponseBody
    public Evenement retrieveEvent(@PathVariable("id-Event") Long id) {
        return eventservice.retrieveEvent(id);
    }

    @PostMapping("/addEvent")
    @ResponseBody
    public Evenement addEvent(Evenement e) {
        return eventservice.addEvent(e);
    }

    @PutMapping("/update/Event")
    @ResponseBody
    public Evenement updateEvent(Evenement e) {
        return eventservice.updateEvent(e);
    }

    @DeleteMapping("/delete/{id-Event}")
    @ResponseBody
    public void deleteEvent(Long id) {
        eventservice.deleteEvent(id);
    }
}
