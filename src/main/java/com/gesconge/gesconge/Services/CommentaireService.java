package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Commentaire;
import com.gesconge.gesconge.Entities.Post;
import com.gesconge.gesconge.Repositories.ICommentaireRepo;
import com.gesconge.gesconge.Repositories.IPostRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*@Setter
@Getter
@Service
@AllArgsConstructor*/

public class CommentaireService /*implements ICmmentaireService*/{
   /* @Autowired
     ICommentaireRepo commentaireRepoREPO;
    @Autowired
    IPostRepo postRepo;

    /*@Override
    public List<Commentaire> retrieveAllcommentaires() {
        return commentaireRepoREPO.findAll();
    }*/

   /* @Override
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
    }/*

   /* @Override
    public Commentaire addCommentaireParPost(Commentaire C, long Id_post) {
        // Trouver le post correspondant à l'ID fourni
        Optional<Post> optionalPost = postRepo.findById(Id_post);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();

            // Associer le commentaire au post
         //   C.setPost(post);

            // Ajouter le commentaire à la liste des commentaires du post
            post.getListCommentaire().add(C);

            // Enregistrer le post mis à jour avec le nouveau commentaire
            postRepo.save(post);

            // Retourner le commentaire ajouté
            return C;
        } else {
            throw new IllegalArgumentException("Post not found with ID: " + Id_post);
        }
    }*/
}
