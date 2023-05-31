package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Reclamation;

import java.util.List;

public interface IReclamationService {
    Reclamation addReclamation(Reclamation reclamation);
    void deleteReclamation(Long id);
    List<Reclamation> retrieveAllReclamations();
    Reclamation updateReclamation(Reclamation updatedRec);
    Reclamation retrieveReclamation(Long id);
}
