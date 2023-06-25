package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Employee;
import com.gesconge.gesconge.Entities.Post;
import com.gesconge.gesconge.Entities.Comment;
import com.gesconge.gesconge.Repositories.ICommentRepo;
import com.gesconge.gesconge.Repositories.IEmployee;
import com.gesconge.gesconge.Repositories.IPostRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Setter
@Getter
@Service
@AllArgsConstructor

public class CommentService implements ICommentService {
    @Autowired
    ICommentRepo commentRepo;
    @Autowired
    IPostRepo postRepo;
    @Autowired
    IEmployee employeeRepo;


    @Override
    public List<Comment> retrieveallComment() {
        return commentRepo.findAll();
    }

    @Override
    public Comment retrievecomment(Long Id_comment) {
        return commentRepo.findById(Id_comment).orElse(null);
    }

    @Override
    public void deletecomment(Long Id_comment) {
        commentRepo.deleteById(Id_comment);
    }


    public Comment addCommentaireParPostETEmploye(Comment c, Long Id_post, long Id_Emp) {
        Post post = postRepo.findById(Id_post).orElse(null);
        Employee employee = employeeRepo.findById(Id_Emp).orElse(null);

        if (post != null && employee != null) {
            c.setPost(post);
            c.setEmployee(employee);

            post.getListCommentaire().add(c);
            employee.getListCommentaires().add(c);

            return commentRepo.save(c);
        }

        return null; // Return null if the post or employee does not exist
    }




    public List<Comment>getallcommentsByEmployee(long Id_Employee) {
        Employee employee = employeeRepo.findById(Id_Employee).orElse(null);

        if (employee != null) {
            return new ArrayList<>(employee.getListCommentaires());
        } else {
            return Collections.emptyList();
        }
    }


    public List<Comment> getallcommentsByPost(Long Id_Post) {
        Post post = postRepo.findById(Id_Post).orElse(null);

        if (post != null) {
            return new ArrayList<>(post.getListCommentaire());
        } else {
            return Collections.emptyList();
        }
    }


}




