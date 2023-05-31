package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Equipe;
import com.gesconge.gesconge.Repositories.IEquipe;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EquipeService implements IEquipeService{

    private IEquipe equipeREPO;
    @Override
    public List<Equipe> retrieveAllEquipes() {
        return equipeREPO.findAll();
    }

    @Override
    public Equipe retrieveEquipe(Long id) {
        return equipeREPO.findById(id).get();
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeREPO.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeREPO.save(e);
    }

    @Override
    public void deleteEquipe(Long id) {
        equipeREPO.deleteById(id);
    }
}
