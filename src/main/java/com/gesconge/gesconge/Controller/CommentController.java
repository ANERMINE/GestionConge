package com.gesconge.gesconge.Controller;

import com.gesconge.gesconge.Entities.Comment;
import com.gesconge.gesconge.Services.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/Comments")
public class CommentController {
    @Autowired
    ICommentService commentService;

    @GetMapping("/allcomments")
    @ResponseBody
    List<Comment>retrieveallComment(){
        return commentService.retrieveallComment();
    }
    @GetMapping("/getcommentByID/{Id_comment}")
    @ResponseBody
    Comment retrievecomment(@PathVariable("Id_comment") Long Id_comment){
        return commentService.retrievecomment(Id_comment);
    }

    @DeleteMapping("/delete/{Id_comment}")
    @ResponseBody
    void deletecomment(@PathVariable("Id_comment") Long Id_comment){
        commentService.deletecomment(Id_comment);
    }


        @PostMapping("/addCommentByPostETEmploye/{Id_post}/{Id_Emp}")
    @ResponseBody
    public Comment addCommentaireParPostETEmploye(@RequestBody Comment c, @PathVariable("Id_post") Long Id_post, @PathVariable("Id_Emp") long Id_Emp)  {
        return commentService.addCommentaireParPostETEmploye(c,Id_post,Id_Emp);
    }

    @GetMapping("/getcomments/employee/{Id_Employee}")
    @ResponseBody
    public List<Comment>getallcommentsByEmployee(@PathVariable("Id_Employee") long Id_Employee){
        return commentService.getallcommentsByEmployee(Id_Employee);
    }


    @GetMapping("/getcomments/post/{Id_Post}")
    @ResponseBody
    public List<Comment> getallcommentsByPost(@PathVariable("Id_Post") Long  Id_Post){
        return commentService.getallcommentsByPost(Id_Post);
    }

}
