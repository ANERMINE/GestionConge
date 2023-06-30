package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Conge;
import com.gesconge.gesconge.Entities.Employee;
import com.gesconge.gesconge.Entities.EtatConge;
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
import java.util.Date;
import java.util.List;

@Service
public class CongeService implements ICongeService{

    @Autowired
    public IConge congeRespository;
    @Autowired
    public IEmployee empRepository;

    public float GetNombreJours(Date Start, Date End)
    {

        long totalDays = ChronoUnit.DAYS.between(Start.toInstant(), End.toInstant());
        long weekends = 0;

        LocalDate startDate = Start.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endDate = End.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
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
        c.setEtat(EtatConge.En_attente);
        Createur.getCongePris().add(c);
        Validateur.getCongeTraite().add(c);
        Createur.setSolde(Createur.getSolde()-GetNombreJours(c.getDateDebut(),c.getDateFin()));
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
