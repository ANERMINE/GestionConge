package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Evenement;
import com.gesconge.gesconge.Entities.Score;

import java.util.List;

public interface IScoreService {
    List<Score> retrieveAllScores();
    Score retrieveScore(Long id);
    Score updateScore(Score s);
    void deleteScore(Long id);
    //Score addscoretoemploye(Score s, Long idemploye);


}
