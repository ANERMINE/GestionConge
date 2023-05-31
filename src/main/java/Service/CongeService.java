package Service;

import Entities.Conge;
import Repository.CongeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CongeService implements ICongeService{

    @Autowired
    public CongeRespository congeRespository;
    @Override
    public Conge addConge(Conge c) {
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
