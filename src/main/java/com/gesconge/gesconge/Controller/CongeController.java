package com.gesconge.gesconge.Controller;


import com.gesconge.gesconge.Services.ICongeService;
import com.gesconge.gesconge.Entities.Conge;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conge")
@RequiredArgsConstructor
public class CongeController {

    @Autowired
    public ICongeService iCongeService;

    @PostMapping("/add/{idemp}")
    @ResponseBody
    public Conge addDemandeConge(@RequestBody Conge c,@PathVariable("idemp") long IdEmp) {
        return iCongeService.addDemandeConge(c,IdEmp);
    }


    @GetMapping("/all")
    public List<Conge> retreiveAllConges() {

        return iCongeService.retreiveAllConges();
    }


    @GetMapping("/conge/{Id_Conge}")
    public Conge retreiveConge(@PathVariable("Id_Conge") Long Id_Conge) {

        return iCongeService.retreiveConge(Id_Conge);
    }


    @ResponseBody
    @PutMapping("/updateconge")
    public Conge updateConge(Conge c) {

        return iCongeService.updateConge(c);
    }


}
