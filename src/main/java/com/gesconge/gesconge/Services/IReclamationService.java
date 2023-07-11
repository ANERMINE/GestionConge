package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Employee;
import com.gesconge.gesconge.Entities.Reclamation;
import com.gesconge.gesconge.Entities.TypeReclamation;

import java.util.List;

public interface IReclamationService  {
    Reclamation addReclamation(Reclamation reclamation);
    void deleteReclamation(Long id);
    List<Reclamation> retrieveAllReclamations();
    Reclamation updateReclamation(Reclamation updatedRec);
    Reclamation retrieveReclamation(Long id);
    List<Reclamation> findByEmployeeAndType(Employee employee, TypeReclamation type);
    boolean hasExistingLeaveRequest(Employee employee);
}
