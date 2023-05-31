package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Reclamation;
import com.gesconge.gesconge.Repositories.IReclamation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclamationService implements IReclamationService{
    @Autowired
    IReclamation r;

    public Reclamation addReclamation(Reclamation reclamation){
        return r.save(reclamation);
    }
    public void deleteReclamation(Long id){
        r.deleteById(id);
    }
    public List<Reclamation> retrieveAllReclamations(){
        return r.findAll();
    }
    public Reclamation updateReclamation(Reclamation updatedRec){
        Reclamation reclamation = r.findById(updatedRec.getIdReclamation()).get();


            // Update the properties of the existing client with the updated values
            reclamation.setType(updatedRec.getType());
            reclamation.setDateCreation(updatedRec.getDateCreation());
            reclamation.setEtat(updatedRec.getEtat());

            // Save the updated client and return the updated entity
          return r.save(reclamation);

    }
    public Reclamation retrieveReclamation(Long id){
        return r.getReferenceById(id);
    }
}
