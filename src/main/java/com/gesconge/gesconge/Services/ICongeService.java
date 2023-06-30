package com.gesconge.gesconge.Services;


import com.gesconge.gesconge.Entities.Conge;

import java.util.Date;
import java.util.List;

public interface ICongeService {
    public Conge addDemandeConge(Conge c,long IdEmp);

    public List<Conge> retreiveAllConges();

    public Conge retreiveConge(Long Id_Conge);

    public Conge updateConge(Conge c);
    public float GetNombreJours(Date StartDate, Date EndDate);

}
