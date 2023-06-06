package com.gesconge.gesconge.Controller;

import com.gesconge.gesconge.Services.IReclamationService;
import com.gesconge.gesconge.Entities.Reclamation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public Reclamation addReclamation(@RequestBody Reclamation r, @RequestParam("file") MultipartFile file) throws IOException {
        return ReclamationService.addReclamation(r,file);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public Reclamation updateReclamation(Reclamation updatedRec) {
        return ReclamationService.updateReclamation(updatedRec);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteReclamation(@PathVariable("id") Long id) {
        ReclamationService.deleteReclamation(id);
    }

}
