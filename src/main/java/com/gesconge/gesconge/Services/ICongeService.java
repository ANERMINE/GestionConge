package com.gesconge.gesconge.Services;


import com.gesconge.gesconge.Entities.Conge;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface ICongeService {
    public Conge addDemandeConge(Conge c, long IdEmp);

    public List<Conge> retreiveAllConges();

    public Conge retreiveConge(Long Id_Conge);

    public Conge updateConge(Conge c);
    public float GetNombreJours(Date StartDate, Date EndDate);
    public Set<Conge> GetListConge(long idEmp);
    public void ValiderConge(long idConge);
    public void RefuserConge(long idConge);

}
