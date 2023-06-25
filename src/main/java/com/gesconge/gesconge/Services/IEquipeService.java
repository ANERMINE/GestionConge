package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Equipe;

import java.util.List;

public interface IEquipeService {
    List<Equipe> retrieveAllEquipes();
    Equipe retrieveEquipe(Long id);
    Equipe addEquipe(Equipe e);
    Equipe updateEquipe(Equipe e);
    void deleteEquipe(Long id);
    Equipe findEquipeByCode(String codeEq);
}
