package com.gesconge.gesconge.Controller;

import com.gesconge.gesconge.Services.IReclamationService;
import com.gesconge.gesconge.Entities.Reclamation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Reclamation")
public class ReclamationController {
    @Autowired
    private IReclamationService ReclamationService;

    @GetMapping("/AllRec")
    @ResponseBody
    public List<Reclamation> retrieveAllReclamations() {
        return ReclamationService.retrieveAllReclamations();
    }

    @GetMapping("/ReclamationID/{id}")
    @ResponseBody
    public Reclamation retrieveReclamation(@PathVariable("id") Long id) {
        return ReclamationService.retrieveReclamation(id);
    }

    @PostMapping("/addRec")
    @ResponseBody
    public Reclamation addReclamation(@RequestBody Reclamation r) {
        return ReclamationService.addReclamation(r);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public Reclamation updateReclamation(@PathVariable("id") Long id , @RequestBody Reclamation r) {
        Reclamation reclamation=ReclamationService.updateReclamation(r.getIdReclamation());
        return reclamation;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteReclamation(@PathVariable("id") Long id) {
        ReclamationService.deleteReclamation(id);
    }

}
