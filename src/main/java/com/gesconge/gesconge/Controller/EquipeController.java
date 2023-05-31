package com.gesconge.gesconge.Controller;

import com.gesconge.gesconge.Services.IEquipeService;
import com.gesconge.gesconge.Entities.Equipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Equipe")

public class EquipeController {

    @Autowired
    private IEquipeService equipeService;

    @GetMapping("/allEquips")
    @ResponseBody
    public List<Equipe> retrieveAllEquips() {
        return equipeService.retrieveAllEquipes();
    }
    @GetMapping("/EquipeByID/{id-Equipe}")
    @ResponseBody
    public Equipe retrieveEquipe(@PathVariable("id-Equipe") Long id) {
        return equipeService.retrieveEquipe(id);
    }

    @PostMapping("/addEquipe")
    @ResponseBody
    public Equipe addEquipe(Equipe e) {
        return equipeService.addEquipe(e);
    }

    @PutMapping("/update/Equipe")
    @ResponseBody
    public Equipe updateEquipe(Equipe e) {
        return equipeService.updateEquipe(e);
    }

    @DeleteMapping("/delete/{id-Equipe}")
    @ResponseBody
    public void deleteEquipe(Long id) {
        equipeService.deleteEquipe(id);
    }
}
