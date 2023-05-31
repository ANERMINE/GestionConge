package Controller;

import Services.ICmmentaireService;
import com.gesconge.gesconge.Entities.Commentaire;
import com.gesconge.gesconge.Entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Commentaire")
public class CommentaireController {
    @Autowired
    private ICmmentaireService commentservice;
    @GetMapping("/allcomments")
    @ResponseBody
    List<Commentaire> retrieveAllcommentaires(){
        return commentservice.retrieveAllcommentaires();

    }

    @GetMapping("/CommentByID/{id-Commentaire}")
    @ResponseBody
    Commentaire retrieveCommentaire(@PathVariable("id-Commentaire") Long id) {
        return commentservice.retrieveCommentaire(id);
    }

    @PostMapping("/addComment")
    @ResponseBody
    Commentaire addCommentaire(Commentaire C){
        return commentservice.addCommentaire(C);
    }
    @DeleteMapping("/delete/{id-Comment}")
    @ResponseBody
    public void deleteCommentaire(Long id) {
        commentservice.deleteCommentaire(id);
    }

}
