package com.gesconge.gesconge.Controller;

import com.gesconge.gesconge.Entities.Equipe;
import com.gesconge.gesconge.Services.EvenementService;
import com.gesconge.gesconge.Services.IEvenementService;
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
    public Evenement addEvent(@RequestBody Evenement e) {
        return eventservice.addEvent(e);
    }

    @PutMapping("/update/Event")
    @ResponseBody
    public Evenement updateEvent(@RequestBody Evenement e) {
        return eventservice.updateEvent(e);
    }

    @DeleteMapping("/delete/{id-Event}")
    @ResponseBody
    public void deleteEvent(Long id) {
        eventservice.deleteEvent(id);
    }
    @PostMapping("/addeveentToequipe/{idEquipe}")
    @ResponseBody
    public Evenement addeventtoequipe(@RequestBody Evenement evenement, @PathVariable Long idEquipe) {
        return eventservice.addeventtoequipe(evenement,idEquipe);

    }
}
