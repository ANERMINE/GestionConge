package com.gesconge.gesconge.Controller;

import com.gesconge.gesconge.Entities.Post;
import com.gesconge.gesconge.Services.ICmmentaireService;
import com.gesconge.gesconge.Entities.Commentaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*@RestController
/*@RequestMapping("/Commentaire")*/
public class CommentaireController {
    /*@Autowired
    private ICmmentaireService commentservice;
   /* @GetMapping("/allcomments")
    @ResponseBody
    List<Commentaire> retrieveAllcommentaires(){
        return commentservice.retrieveAllcommentaires();

    }*/

   /* @GetMapping("/CommentByID/{id-Commentaire}")
    @ResponseBody
    Commentaire retrieveCommentaire(@PathVariable("id-Commentaire") Long id) {
        return commentservice.retrieveCommentaire(id);
    }*/

    /*@PostMapping("/addComment")
    @ResponseBody
    Commentaire addCommentaire(Commentaire C){
        return commentservice.addCommentaire(C);
    }
   /* @PostMapping("/addCommentByPost/{id-Post}")
    @ResponseBody
    public Commentaire addCommentaireParPost(@RequestBody Commentaire C, @PathVariable ("id-Post") long Id_post) {
        return commentservice.addCommentaireParPost(C,Id_post);
    }*/

   /* @DeleteMapping("/delete/{id-Comment}")
    @ResponseBody
    public void deleteCommentaire(@PathVariable ("id-Comment") Long id) {
        commentservice.deleteCommentaire(id);
    }*/

}
