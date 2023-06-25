package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Comment;

import java.util.List;
import java.util.Optional;

public interface ICommentService {
    public Comment addCommentaireParPostETEmploye(Comment c, Long Id_post, long Id_Emp) ;
    public List<Comment> getallcommentsByEmployee(long Id_Employee);
    public List<Comment> getallcommentsByPost(Long Id_Post);
    List <Comment> retrieveallComment();
    Comment retrievecomment(Long Id_comment);
    void deletecomment(Long Id_comment);
}
