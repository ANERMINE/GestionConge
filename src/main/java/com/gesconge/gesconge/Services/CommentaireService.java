package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Commentaire;
import com.gesconge.gesconge.Entities.Post;
import com.gesconge.gesconge.Repositories.ICommentaireRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
@Setter
@Getter
@Service
@AllArgsConstructor

public class CommentaireService implements ICmmentaireService{

    private ICommentaireRepo commentaireRepoREPO;
    @Override
    public List<Commentaire> retrieveAllcommentaires() {
        return commentaireRepoREPO.findAll();
    }

    @Override
    public Commentaire retrieveCommentaire(Long id) {
        return commentaireRepoREPO.findById(id).get();
    }

    @Override
    public Commentaire addCommentaire(Commentaire C) {
        return commentaireRepoREPO.save(C);
    }


    @Override
    public void deleteCommentaire(Long id) {
          commentaireRepoREPO.deleteById(id);
    }

    @Override
    public Commentaire addCommentaireParPost(Commentaire C, Post P) {
       C.setPost(P);
       return  commentaireRepoREPO.save(C);
    }
}
