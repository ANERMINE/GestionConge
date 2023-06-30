package com.gesconge.gesconge.Controller;


import com.gesconge.gesconge.Services.ICongeService;
import com.gesconge.gesconge.Entities.Conge;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/conge")
@RequiredArgsConstructor
public class CongeController  {

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
    @ResponseBody
    @GetMapping("/GetNbJour/{Start}/{End}")
    public float GetNombreJours(@PathVariable("Start")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date Start ,@PathVariable("End")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  Date End)
    {
        return iCongeService.GetNombreJours(Start,End);
    }

}
