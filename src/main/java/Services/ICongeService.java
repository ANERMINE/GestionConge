package Services;


import com.gesconge.gesconge.Entities.Conge;

import java.util.List;

public interface ICongeService {
    public Conge addConge(Conge c);

    public List<Conge> retreiveAllConges();

    public Conge retreiveConge(Long Id_Conge);

    public Conge updateConge(Conge c);
}
