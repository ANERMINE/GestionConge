package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Conge;
import com.gesconge.gesconge.Entities.Employee;
import com.gesconge.gesconge.Repositories.IConge;

import com.gesconge.gesconge.Repositories.IEmployee;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.DayOfWeek;
import java.time.LocalDate;

import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.List;

@Service
public class CongeService implements ICongeService{

    @Autowired
    public IConge congeRespository;
    @Autowired
    public IEmployee empRepository;

    public float GetNombreJours(Conge c)
    {
        long totalDays = ChronoUnit.DAYS.between((Temporal) c.getDateDebut(), (Temporal) c.getDateFin());
        long weekends = 0;

        for (LocalDate date = c.getDateDebut().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); date.isBefore(c.getDateFin().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()); date = date.plusDays(1)) {
            if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                weekends++;
            }
        }

        return totalDays - weekends;

    }
    @Override
    public Conge addDemandeConge(Conge c, long IdEmp) {
        Employee Createur=new Employee();
        Employee Validateur=new Employee();
        Createur=empRepository.findById(IdEmp).get();
        Validateur=Createur.getResponsable();
        c.setCreateur(Createur);
        c.setValidateur(Validateur);
        Createur.getCongePris().add(c);
        Validateur.getCongeTraite().add(c);
        Createur.setSolde(GetNombreJours(c));
        return congeRespository.save(c);
   }

    @Override
    public List<Conge> retreiveAllConges() {

        return congeRespository.findAll();
    }

    @Override
    public Conge retreiveConge(Long Id_Conge) {

        return congeRespository.getReferenceById(Id_Conge);
    }

    @Override
    public Conge updateConge(Conge c) {

        return congeRespository.save(c);
    }
}
