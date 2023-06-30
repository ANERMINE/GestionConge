package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Conge;
import com.gesconge.gesconge.Entities.Employee;
import com.gesconge.gesconge.Entities.EtatConge;
import com.gesconge.gesconge.Repositories.IConge;

import com.gesconge.gesconge.Repositories.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.DayOfWeek;
import java.time.LocalDate;

import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
    public Set<Conge> GetListConge(long idEmp) {
        Employee emp=empRepository.findById(idEmp).get();
        Set<Conge>  t=emp.getCongeTraite();
        return emp.getCongeTraite();
    }

    @Override
    public void ValiderConge(long idConge) {
        Conge c =new Conge();
        congeRespository.findById(idConge).get();
        c.setEtat(EtatConge.Valide);
        congeRespository.save(c);

    }

    @Override
    public void RefuserConge(long idConge) {
        Conge c =new Conge();
        Employee emp=new Employee();
        emp=c.getCreateur();
        emp.setSolde(emp.getSolde()+GetNombreJours(c.getDateDebut(),c.getDateFin()));

        congeRespository.findById(idConge).get();
        c.setEtat(EtatConge.Refuse);
        congeRespository.save(c);
    }


    @Override
    public Conge addDemandeConge(Conge c, long IdEmp) {
        Employee Createur=new Employee();
        Employee validateur=new Employee();
        Conge c1=new Conge();
        Createur=empRepository.findById(IdEmp).get();

        c.setCreateur(Createur);

        c.setEtat(EtatConge.En_attente);
        Createur.getCongePris().add(c);

        Createur.setSolde(Createur.getSolde()-GetNombreJours(c.getDateDebut(),c.getDateFin()));

        c1=congeRespository.save(c);
        if (Createur.getResponsable()!=null)
        {
            validateur=Createur.getResponsable();
            validateur.getCongeTraite().add(c1);
            c1.setValidateur(validateur);
        }
        empRepository.save(validateur);
        return c1;
   }

    @Override
    public List<Conge> retreiveAllConges() {

        return congeRespository.findAll();
    }

    @Override
    public Conge retreiveConge(Long Id_Conge) {

        return congeRespository.findById(Id_Conge).get();
    }

    @Override
    public Conge updateConge(Conge c) {

        return congeRespository.save(c);
    }


}
