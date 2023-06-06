package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Employee;
import com.gesconge.gesconge.Entities.Reclamation;
import com.gesconge.gesconge.Entities.TypeReclamation;
import com.gesconge.gesconge.Repositories.IReclamation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReclamationService implements IReclamationService{
    @Autowired
    IReclamation r;

    public Reclamation addReclamation(Reclamation reclamation,MultipartFile file) throws IOException {
        if (reclamation.getType() == TypeReclamation.DemandeSoldeConge) {
            if (hasExistingLeaveRequest(reclamation.getEmployee())) {
                throw new IllegalArgumentException("Vous avez deja créé une demande de solde de congé vous ne pouvez pas créér une autre");
            }
            if (reclamation.getnbJours() > 7) {
                throw new IllegalArgumentException("Le nombre de jours demandé ne peut pas dépasser 7");
            }
            if (reclamation.getnbJours() == 0) {
                throw new IllegalArgumentException("Vous devz spécifier le nombre de jours à demander");
            }
        } else {
            reclamation.setnbJours(0);
        }
        if (file != null && !file.isEmpty()) {
            String filePath = storeFile(file);
            reclamation.setPieceJointe(filePath);
        }
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

            reclamation.setType(updatedRec.getType());
            reclamation.setDateCreation(updatedRec.getDateCreation());
            reclamation.setEtat(updatedRec.getEtat());
          return r.save(reclamation);

    }
    public Reclamation retrieveReclamation(Long id){
        return r.getReferenceById(id);
    }

    private String storageDirectory ="C:\\Users\\zbasm\\Desktop\\StockageFichiers";
    public String storeFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String filePath = storageDirectory + File.separator + fileName;
        File targetFile = new File(filePath);
        file.transferTo(targetFile);
        return filePath;
    }
    public List<Reclamation> findByEmployeeAndType(Employee employee, TypeReclamation type) {
        List<Reclamation> reclamations = r.findAll();
        List<Reclamation> filteredReclamations = new ArrayList<>();

        for (Reclamation reclamation : reclamations) {
            if (reclamation.getEmployee().equals(employee) && reclamation.getType() == type) {
                filteredReclamations.add(reclamation);
            }
        }

        return filteredReclamations;
    }
    public boolean hasExistingLeaveRequest(Employee employee) {
        List<Reclamation> reclamations = findByEmployeeAndType(employee, TypeReclamation.DemandeSoldeConge);
        return !reclamations.isEmpty();
    }


}
