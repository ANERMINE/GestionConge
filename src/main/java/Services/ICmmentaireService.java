package Services;

import com.gesconge.gesconge.Entities.Commentaire;
import com.gesconge.gesconge.Entities.Post;

import java.util.List;

public interface ICmmentaireService {
    List<Commentaire> retrieveAllcommentaires();
    Commentaire retrieveCommentaire(Long id);
    Commentaire addCommentaire(Commentaire C);
    void deleteCommentaire(Long id);

    Commentaire addCommentaireParPost(Commentaire C,Post P);
}
