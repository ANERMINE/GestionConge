package com.gesconge.gesconge.Controller;

import com.gesconge.gesconge.Entities.Employee;
import com.gesconge.gesconge.Entities.TypeReclamation;
import com.gesconge.gesconge.Services.IReclamationService;
import com.gesconge.gesconge.Entities.Reclamation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Reclamation")
public class ReclamationController {
    @Autowired
    private IReclamationService ReclamationService;

    @GetMapping("/AllRec")
    public List<Reclamation> retrieveAllReclamations() {
        return ReclamationService.retrieveAllReclamations();
    }

    @GetMapping("/ReclamationID/{id}")
    public Reclamation retrieveReclamation(@PathVariable("id") Long id) {
        return ReclamationService.retrieveReclamation(id);
    }

    @PostMapping("/addRec")
//    @RequestMapping(value="/addRec",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Reclamation>  addReclamation(@RequestBody Reclamation r)  {
        return ResponseEntity.ok().body (ReclamationService.addReclamation(r));
    }

    @PutMapping("/update/{id}")
    public Reclamation updateReclamation(Reclamation updatedRec) {
        return ReclamationService.updateReclamation(updatedRec);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReclamation(@PathVariable("id") Long id) {
        ReclamationService.deleteReclamation(id);
    }

    @GetMapping("/findByEmployeeAndType/{employeeId}/{type}")
    @ResponseBody
    public List<Reclamation> findByEmployeeAndType(@PathVariable("employee") Employee employee, @PathVariable("type") TypeReclamation type) {

        return ReclamationService.findByEmployeeAndType(employee, type);
    }
}
