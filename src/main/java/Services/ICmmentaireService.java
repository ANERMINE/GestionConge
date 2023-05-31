package Services;

import com.gesconge.gesconge.Entities.Commentaire;

import java.util.List;

public interface ICmmentaireService {
    List<Commentaire> retrieveAllcommentaires();
    Commentaire retrieveCommentaire(Long id);
    Commentaire addCommentaire(Commentaire C);
    void deleteCommentaire(Long id);
}
