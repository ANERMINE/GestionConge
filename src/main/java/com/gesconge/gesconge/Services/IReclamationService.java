package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Employee;
import com.gesconge.gesconge.Entities.Reclamation;
import com.gesconge.gesconge.Entities.TypeReclamation;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IReclamationService  {
    Reclamation addReclamation(Reclamation reclamation, MultipartFile file) throws IOException;
    void deleteReclamation(Long id);
    List<Reclamation> retrieveAllReclamations();
    Reclamation updateReclamation(Reclamation updatedRec);
    Reclamation retrieveReclamation(Long id);
    List<Reclamation> findByEmployeeAndType(Employee employee, TypeReclamation type);
    boolean hasExistingLeaveRequest(Employee employee);
}
